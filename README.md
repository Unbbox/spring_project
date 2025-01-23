# 언빡스 카페
## 2025.01.13 - 2025.01.23


# 목차

- 프로젝트 개요
- 프로젝트 구성
- 프로젝트 수행과정 및 결과
- 프로젝트 후기


# 1. 프로젝트 개요

## ❕ 프로젝트 필요성 ❕

기본적인 게시판 CRUD(Create, Read, Update, Delete)와
스프링 시큐리티를 통한 인증 및 인가 과정을
보여주기 위한 예시 프로젝트 필요

# =>

게시판 CRUD와 스프링 시큐리티(로그인, 로그아웃), 기본적인
보안처리(xss 공격방지, csrf 방지) 해결방법 제시


# 2. 프로젝트 구성

## ** 기술 스택 개요 **

|  ** OS **   |  ** Server **  | ** Database ** | ** Testing ** |
|-------------|----------------|----------------|---------------|
|


### 시스템 아키텍처

#### 시퀀스 다이어그램
![시퀀스 다이어그램]

#### 데이터베이스 구조
![DB 구조]

#### API 설계
![API 구조] ![api 구조](https://github.com/user-attachments/assets/9b99d3e1-730f-4371-94a0-22231028fb9b)


## API 명세서
| Method | EndPoint | 설명 |
|--------|----------|------|
| DELETE | /menu/delete/{idx} | 메뉴 삭제 |
| GET | /menu/{idx} | 메뉴 상세 조회 |
| GET | /menu/all | 전체 메뉴 조회 |
| POST | /menu/add | 메뉴 추가 |
| PUT | /menu/update/{idx} | 메뉴 수정 |
| PUT | /menu/count/{idx} | 조회수 증가 |
