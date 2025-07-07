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
- Python FastAPI (챗봇 서버)
- LangChain (자연어 처리)

## 프로젝트 구조

```
LangChain_ChatBot/
├── python/                      # Python 챗봇 서버
│   ├── ChatBot.py               # FastAPI 서버 구현
│   └── README.md                # Python 서버 설정 및 실행 방법
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── fastcampus/
│   │   │           └── langchain_chatbot/
│   │   │               ├── config/
│   │   │               │   └── RestTemplateConfig.java
│   │   │               ├── controller/
│   │   │               │   ├── ChatController.java
│   │   │               │   └── SimpleController.java
│   │   │               ├── dto/
│   │   │               │   ├── ChatRequest.java
│   │   │               │   └── ChatResponse.java
│   │   │               ├── exception/
│   │   │               │   ├── ChatbotException.java
│   │   │               │   └── GlobalExceptionHandler.java
│   │   │               ├── service/
│   │   │               │   └── ChatService.java
│   │   │               └── LangChainChatBotApplication.java
│   │   └── resources/
│   │       ├── static/
│   │       │   └── chat.html
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── com/
│               └── fastcampus/
│                   └── langchain_chatbot/
│                       └── LangChainChatBotApplicationTests.java
└── README.md                    # 이 파일
```

## 설치 및 실행 방법

### 사전 요구사항

- Java 21 이상
- Gradle
- Python 3.8 이상
- pip (Python 패키지 관리자)

### Spring Boot 애플리케이션 설정 및 실행

1. 저장소 클론
   ```bash
   git clone https://github.com/yourusername/LangChain_ChatBot.git
   cd LangChain_ChatBot
   ```

2. 애플리케이션 빌드
   ```bash
   ./gradlew build
   ```

3. 애플리케이션 실행
   ```bash
   ./gradlew bootRun
   ```

Spring Boot 애플리케이션은 기본적으로 http://localhost:8080 에서 실행됩니다.

### Python 챗봇 서버 설정 및 실행

Python 챗봇 서버 설정 및 실행에 대한 자세한 내용은 [python/README.md](python/README.md) 파일을 참조하세요.

간단한 요약:

1. 필요한 패키지 설치
   ```bash
   pip install fastapi uvicorn python-dotenv langchain-openai langchain-core pydantic
   ```

2. `.env` 파일 생성 및 OpenAI API 키 설정

3. FastAPI 서버 실행
   ```bash
   cd python
   uvicorn ChatBot:app --reload --host 0.0.0.0 --port 8000
   ```

## API 엔드포인트

### Spring Boot 애플리케이션

- **채팅 페이지**: `/chat` 또는 `/`
- **채팅 API**: `/chat` (POST)
- **홈 페이지**: `/home`

### Python FastAPI 서버

- **질문 API**: `/ask` (POST)

## 설정

`application.properties` 파일에서 다음 설정을 변경할 수 있습니다:

```properties
# FastAPI 서버 URL
fastapi.url=http://localhost:8000/ask
```

## 사용 예시

1. Python FastAPI 서버 실행
2. Spring Boot 애플리케이션 실행
3. 웹 브라우저에서 http://localhost:8080 접속
4. 채팅 인터페이스에서 질문 입력
5. 서버로부터 응답 수신

## 오류 처리

애플리케이션은 다음과 같은 오류 상황을 처리합니다:

- FastAPI 서버 연결 실패
- 서버 응답 오류
- 기타 예상치 못한 오류

## 라이센스

이 프로젝트는 MIT 라이센스 하에 배포됩니다.