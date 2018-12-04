1. MyBatis 라이브러리 추가
    1-1. mvnReapository.com에서 mybatis를 검색, 라이브러리 정보를 알아낸다.
    1-2. build.gradle 파일에 등록한다
    1-3. gradle eclipse 실행하여 이클립스 설정 파일을 갱신
    1-4. 이클립스 프로젝트 refrash
    1-5. referenced libraries에 mybatis 추가됐는지 확인

2. mybatis 설정파일 추가

    -mybatis.org 사이트의 문서를 참고하여 mybatis-config.xml 파일을 작성한다

    -jdbc.properties 파일을 작성한다.
        -dbms연결 정보를 둔다
        -mybatis 설정파일에서 참고할 것이다

    -디렉토리는 src/main/resources/com/eomcs/lms/conf. 여기에 파일을 둔다
    -'src/main/resources' 폴더 추가 후 자바 소스 폴더로 등록해야 한다.
    -즉 폴더를 만든 후에 'gradle eclipse'를 재실행해야한다
    -물론 이클립스에서도 프로잭트 refrash


3. sql 분리

- src/main/resources/com/eomcs/lms/mapper/boardMapper.xml 파일 작성한다
- BoardDao 클래스에 있는 sql을 이 파일로 옮긴다
- 물론 MyBatis 문서를 참고하여 작성하라


4. sqlsessionfactory 인스터느 생성

    app클래스에서 mybatis의 sqlsesionFActory개

5. dao 적용