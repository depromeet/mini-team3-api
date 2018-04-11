# mini-team3-api

디프만 미니프로젝트 3팀 API

기본 컨셉은 `여행일기`이며, 짧은 시간 내에 협업을 경험한다는 목적으로 로그인과 회원가입 기능만 구현하였습니다.

본 애플리케이션은 [Heroku](https://depromeet-mini-team3-api.herokuapp.com)를 통해 배포되었습니다.

## Documentation

API 문서는 [Swagger](https://depromeet-mini-team3-api.herokuapp.com/swagger-ui.html)를 통해 제공됩니다.

## Installation

먼저, git을 통해 프로젝트를 clone합니다:
```
$ git clone https://github.com/depromeet/mini-team3-api.git
```

clone한 프로젝트 경로로 이동해 다음 maven 명령을 수행합니다:
```
$ mvnw clean install
```

프로젝트 내의 target 디렉터리로 이동해 다음 명령으로 애플리케이션을 실행합니다:
```
$ java -jar [application-name].jar
```
