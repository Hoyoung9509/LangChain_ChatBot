# LangChain ChatBot

Spring Boot 기반의 채팅 애플리케이션으로, FastAPI 챗봇 서버와 통신하여 사용자의 질문에 대한 답변을 제공합니다.

## 기능

- 사용자 친화적인 웹 기반 채팅 인터페이스
- FastAPI 서버와의 REST API 통신
- 오류 처리 및 예외 관리
- 반응형 디자인으로 다양한 디바이스 지원

## 기술 스택

- Java 21
- Spring Boot 3.1.0
- Spring Web
- RestTemplate
- HTML/CSS/JavaScript

## 프로젝트 구조

```
```

## 설치 및 실행 방법

### 사전 요구사항

- Java 21 이상
- Gradle


1. 저장소 클론
   ```bash
   git clone https://github.com/yourusername/LangChain_ChatBot.git
   cd LangChain_ChatBot
   ```

2. 애플리케이션 빌드
   ```bash
   ./gradlew build
   ```

   ```bash
   ./gradlew bootRun
   ```


## API 엔드포인트


- **채팅 페이지**: `/chat` 또는 `/`
- **홈 페이지**: `/home`

## 설정

`application.properties` 파일에서 다음 설정을 변경할 수 있습니다:

```properties
# FastAPI 서버 URL
fastapi.url=http://localhost:8000/ask
```

## 사용 예시


## 오류 처리

애플리케이션은 다음과 같은 오류 상황을 처리합니다:

- FastAPI 서버 연결 실패
- 서버 응답 오류
- 기타 예상치 못한 오류

## 라이센스

이 프로젝트는 MIT 라이센스 하에 배포됩니다.
