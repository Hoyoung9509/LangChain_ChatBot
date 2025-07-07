# ChatBot Python Server

이 디렉토리에는 LangChain을 사용한 FastAPI 기반 챗봇 서버가 포함되어 있습니다.

## 필요 조건

- Python 3.8 이상
- pip (Python 패키지 관리자)

## 설치 방법

1. 필요한 패키지 설치:

```bash
pip install fastapi uvicorn python-dotenv langchain-openai langchain-core pydantic
```

2. `.env` 파일 생성:

프로젝트 루트 디렉토리에 `.env` 파일을 생성하고 다음 내용을 추가합니다:

```
OPENAI_API_KEY=your_openai_api_key_here
```

## 실행 방법

다음 명령어로 FastAPI 서버를 실행합니다:

```bash
cd python
uvicorn ChatBot:app --reload --host 0.0.0.0 --port 8000
```

서버는 기본적으로 `http://localhost:8000`에서 실행됩니다.

## API 엔드포인트

### 질문 전송

- **URL**: `/ask`
- **Method**: `POST`
- **Request Body**:
  ```json
  {
    "question": "질문 내용"
  }
  ```
- **Response**:
  ```json
  {
    "answer": "답변 내용"
  }
  ```

## 사용 예시

```python
import requests

response = requests.post(
    "http://localhost:8000/ask",
    json={"question": "이름이 뭐야?"}
)

print(response.json())
```

## 주의사항

- 이 서버는 Spring Boot 애플리케이션과 별도로 실행되어야 합니다.
- Spring Boot 애플리케이션은 이 서버의 `/ask` 엔드포인트를 호출하여 챗봇 기능을 사용합니다.
- 환경 변수 `OPENAI_API_KEY`가 올바르게 설정되어 있는지 확인하세요.