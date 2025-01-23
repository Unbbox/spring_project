# 언빡스 카페
## 2025.01.13 - 2025.01.23


# 목차

1. [프로젝트 개요](#1-프로젝트-개요)
2. [프로젝트 구성](#2-프로젝트-구성)
3. [프로젝트 수행과정 및 결과](#3-프로젝트-수행과정-및-결과)
4. [프로젝트 후기](#4-프로젝트-후기)


## 1. 프로젝트 개요

### ❕ 프로젝트 필요성 ❕

- 기본적인 게시판 CRUD 구현
- 스프링 시큐리티를 통한 인증 및 인가 과정 구현
- XSS 공격방지, CSRF 방지 등 기본적인 보안 처리 해결방법 제시

### 담당 업무
- Spring Security 구현
- API 설계
- DB 설계
- 프로젝트 환경 구성
- 게시판(CRUD) 개발
- 로그인/로그아웃 및 회원가입 기능 구현

## 2. 프로젝트 구성

### 기술 스택

| 구분 | 기술 |
|------|------|
| OS | Windows |
| Database | MySQL |
| Testing | Swagger |
| Frontend | HTML5, CSS3, JavaScript |
| Backend | Spring Boot (v3.4.1), Java (OpenJDK-17) |
| IDE | Visual Studio Code, Eclipse |
| Collaboration | GitHub |


### 시스템 아키텍처

<!-- 
#### 시퀀스 다이어그램
![시퀀스 다이어그램]
-->

#### 데이터베이스 구조
![DB 구조](https://github.com/user-attachments/assets/abee7459-2cfb-4456-86ce-6f8d91e93f4f)


#### API 설계
![api 구조](https://github.com/user-attachments/assets/9b99d3e1-730f-4371-94a0-22231028fb9b)


## API 명세서
| Method | EndPoint | 설명 |
|--------|----------|------|
| DELETE | /menu/delete/{idx} | 메뉴 삭제 |
| GET | /menu/{idx} | 메뉴 상세 조회 |
| GET | /menu/all | 전체 메뉴 조회 |
| POST | /menu/add | 메뉴 추가 |
| PUT | /menu/update/{idx} | 메뉴 수정 |
| PUT | /menu/count/{idx} | 조회수 증가 |

## 3. 프로젝트 수행과정 및 결과

- 수행과정 : 개인프로젝트, 개발 기간 10일 소요.
- 결과
- 칭찬할만한점- 
- 개선해야할점- JWT 토큰 추가제안, 댓글 기능 추가

## 4. 프로젝트 후기
- 직전 프로젝트에선 Spring Security를 사용할 기회가 없어서 아쉬웠는데, 이번 기회에 간단하게라도 사용할 수 있어서 좋았다.
- 이번 프로젝트를 계기로 다음엔 쇼핑몰 API를 만들어 볼 계획이다.
