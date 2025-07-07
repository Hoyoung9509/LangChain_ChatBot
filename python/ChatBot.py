import os
from dotenv import load_dotenv
from fastapi import FastAPI
from pydantic import BaseModel

# ✅ 환경 변수
load_dotenv()
OPENAI_API_KEY = os.getenv("OPENAI_API_KEY")

# 1. 나에 대한 정보
my_profile = """
이름: 정호영
나이 : 30세
취미: 코딩, 대화
서울 날씨: 35도
"""

# 2. 프롬프트 템플릿
from langchain_openai import ChatOpenAI
from langchain_core.prompts import PromptTemplate

prompt = PromptTemplate.from_template(
    "아래는 챗봇의 자기소개입니다.\n{profile}\n\n사용자 질문: {question}\n챗봇 답변:"
)

llm = ChatOpenAI(temperature=0.2, model="gpt-4o-mini")

# 3. 체인 구성
def ask_me(question):
    full_prompt = prompt.format(profile=my_profile, question=question)
    return llm.invoke(full_prompt).content

# 4. 사용 예시
print(ask_me("이름 말해"))

app = FastAPI()

class Question(BaseModel):
    question: str

@app.post("/ask")
def ask(question: Question):
    answer = ask_me(question.question)
    return {"answer": answer}