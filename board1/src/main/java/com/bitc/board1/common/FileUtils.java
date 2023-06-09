package com.bitc.board1.common;

import com.bitc.board1.dto.BoardFileDto;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// @Bean과 @Component는 동일하게 스프링프레임워크에서 객체를 생성하여 사용하고 관리하는 라이브러리라는 의미의 어노테이션
// @Bean : 스프링프레임워크 및 각종 서드파티 회사에서 제공하는 미리 생성해 놓은 라이브러리 (회사나 기업에서 미리 만들어둔 라이브러리는 Bean 붙이면됨) (@Autowired 사용이 가능해짐 -> 생성자 안써도됨)
// @Component : 사용자가 직접 생성한 라이브러리 (내 필요에 의해 만든 라이브러리는 Component 붙이면 됨) (@Autowired 사용이 가능해짐 -> 생성자 안써도됨)


@Component
public class FileUtils {
    public List<BoardFileDto> parseFileInfo(int boardIdx, MultipartHttpServletRequest uploadFiles) throws Exception {
        // 스프링프레임워크가 제공하는 ObjectUtils를 사용하여 업로드된 파일이 있는지 확인, 없으면 true
        if (ObjectUtils.isEmpty(uploadFiles)) {
            // 파일이 없을 경우 바로 종료
            return null;
        }

        // 업로드된 파일 정보가 있을 경우 파일 목록을 저장하기 위한 List 생성
        List<BoardFileDto> fileList = new ArrayList<BoardFileDto>();

        // 시간 정보 패턴 생성
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // 현재 타임존을 기준으로 하여 현재 시간을 가져오기
        ZonedDateTime current = ZonedDateTime.now();
        // 파일 저장 경로 생성, 현재 타임존 기준 시간을 패턴에 맞게 설정하여 출력(images라는 폴더가 경로임)
//        String path = "images/" + current.format(format); // 프로젝트의 내부 폴더를 사용할 때 오류가 나는 경우가 있어
        // 현재 StandardServletMultipartResolver 사용 시 전체 경로가 아니면 파일 복사 시 오류가 발생함
        String path = "C:/upload/" + current.format(format);    // 외부 폴더로 경로를 지정함
        // 자바의 File 클래스 객체 생성, 위에서 지정한 생성한 경로
        File file = new File(path);

        // 지정한 경로가 존재하는지 확인, 있으면 true(그냥 넘어감), 없으면 false(폴더 생성)
        if (file.exists() == false) {
            // 지정한 경로의 폴더 생성
            file.mkdirs();
        }

        // 업로드된 파일 정보에서 파일 이름 목록 가져옴
        Iterator<String> iterator = uploadFiles.getFileNames();

        String newFileName; // 새 파일명을 저장할 변수
        String originalFileExtension;   // 원본 파일의 확장자명을 저장할 변수
        String contentType; // 새 파일의 확장자명을 저장할 변수
        
        // 파일 이름 목록 중 다음 내용이 존재하는지 확인 
        while (iterator.hasNext()) {
            // 파일 이름을 기준으로 해당 파일의 모든 정보를 가져옴, MultipartFile 타입의 리스트에 저장
            List<MultipartFile> fileLists = uploadFiles.getFiles(iterator.next());
            
            // 파일 정보 목록에 있는 내용을 하나씩 출력
            for (MultipartFile multipartFile : fileLists) {
                // 파일 정보가 비었는지 확인, 비었으면 true, 존재하면 false
                if (multipartFile.isEmpty() == false) {
                    // 확장자명 가져오기
                    contentType = multipartFile.getContentType();
                    
                    if (ObjectUtils.isEmpty(contentType)) {
                        break;
                    }
                    else {
                        // 확장자명에 따라 변수에 확장자명 저장
                        if (contentType.contains("image/jpeg")) {
                            originalFileExtension = ".jpg";
                        }
                        else if (contentType.contains("image/png")) {
                            originalFileExtension = ".png";
                        }
                        else if (contentType.contains("image/gif")) {
                            originalFileExtension = ".gif";
                        }
                        else {
                            break;
                        }
                    }

                    // 현재 시간을 기준으로 새 파일명 생성, nanoTime()을 사용하여 동일한 이름이 나올 수 없도록 함, toString으로 문자열로 바꿔줌, 위에서 생성한 확장자명과 문자열을 연결함
                    newFileName = Long.toString(System.nanoTime()) + originalFileExtension;

                    // DB에 저장하기 위한 BoardFileDto 클래스 타입의 객체에 파일 정보 데이터 추가
                    BoardFileDto boardFile = new BoardFileDto();
                    boardFile.setBoardIdx(boardIdx);    // 게시물 번호
                    boardFile.setFileSize(multipartFile.getSize()); // 파일 크기
                    boardFile.setOriginalFileName(multipartFile.getOriginalFilename()); // 파일 원본 이름
                    // 서버에 저장되는 파일이름, 위에서 생성한 파일 저장 경로와 nanoTime()을 이용하여 생성한 파일이름을 합하여 파일을 저장할 전체 경로를 생성함
                    boardFile.setStoredFileName(path + "/" + newFileName);  // 서버에 저장되는 파일 이름

                    // 위에서 생성한 List<BoardFileDto> 타입의 변수에 데이터 추가
                    fileList.add(boardFile);

                    // 자바의 File 클래스 객체를 방금 생성한 파일이름 밍 경로로 생성함
                    file = new File(path + "/" + newFileName);
                    // 서버의 지정된 위치에 실제 파일을 복사함(이 위의 내용들은 전부 메모리 안에서 동작되는 내용들)
                    multipartFile.transferTo(file);
                }
            }
        }
        // 파일 정보 목록을 반환
        return fileList;
    }
}
