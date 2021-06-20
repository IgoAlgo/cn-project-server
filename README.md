# GIST Petition API Docs

GIST 청원사이트 api 명세서 입니다.



## Post API

> GIST 청원사이트 게시판 명세서 입니다.





## 게시글 생성

```http
POST /posts
```

### request body

| field name | type   | require? | description |
| ---------- | ------ | -------- | ----------- |
| title      | String | required | 이메일 제목 |
| content    | String | required | 이메일 내용 |



#### request body example

```json
{
    "title": "기숙사 복도가 평소에 너무 시끌럽습니다.", 
    "content": "기숙사 복도가 너무 시끄럽습니다. 이렇게 소음을 발생시키는 학생에게 벌점을 줄 수 있는 제도를  								만들어주시기를 청원합니다."
}
```

### response

#### success

- `201 CREATED` : 헤더 `location`에 생성된 자원의 URI가 반환됩니다. 

#### fail (작업 예정)

- `400 Bad Request` : 필수 항목 누락

```
{
    "status": 400,
    "message": "필수항목을 입력해주세요. "
}
```





## 모든 게시물 조회

```http
GET /Posts
```


### response

#### success

- `200 OK`

```
[
    {
        "id": 1,
        "name": "new title1",
        "content": "new content2"
    },
    {
        "id": 2,
        "name": "new title2",
        "content": "new content2"
    }
]
```





## 템플릿 수정

```http
PUT /templates/:id
```

### request body

| field name | type   | require? | description |
| ---------- | ------ | -------- | ----------- |
| title      | String | required | 이메일 제목 |
| content    | String | required | 이메일 내용 |



#### request body example

```json
{
    "title": "new title_updated", 
    "content": "new content2_updated"
}
```

### response

#### success

- `200 OK` : Response Body는 따로 없습니다.

#### fail (작업 예정)

- `400 Bad Request` : 필수항목을 입력해주세요.

```
{
    "status": 400,
    "message": "필수항목을 입력해주세요."
}
```





## 템플릿 삭제

```http
DELETE /templates/:id
```



### response

#### success

- `200 OK` : Response Body는 따로 없습니다.

#### fail (작업 예정)

- `400 Bad Request` : 파일 삭제에 실패했습니다.

```
{
    "status": 400,
    "message": "파일 삭제에 실패했습니다."
}
```