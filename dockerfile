FROM openjdk:11-jdk

# 8080 포트에서 프로젝트가 실행되도록 세팅되어 있으므로 8080으로 세팅함(8080 포트가 컨테이너 외부로 노출됨)
EXPOSE 8080

# JAR_FILE 변수 정의 -> 기본적으로 jar file이 2개이기 때문에 이름을 특정해야함
ARG JAR_FILE=./iloveit-app/iloveit-app-api/build/libs/iloveit-app-api-0.0.1-SNAPSHOT.jar

# JAR 파일 메인 디렉토리에 복사
COPY ${JAR_FILE} app.jar

# 시스템 진입점 정의
ENTRYPOINT ["java","-jar","/app.jar"]
