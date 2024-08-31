# Auth Filter

JWT + Filter + ArgumentResolver Example

<br>

## API

| **Method** | **Endpoint**         | **Description**                        | **Parameters**         | **Request Body**                        | **Response**                                 | **Response Headers**                        | **Status Code** |
|------------|----------------------|----------------------------------------|------------------------|-----------------------------------------|----------------------------------------------|---------------------------------------------|-----------------|
| `POST`     | `/v1/auth/signup`     | 유저 가입 (V1)                         | 없음                   | `{ "email": string }`                   | `{ "bearerToken": string }`                  | 없음                                         | `200 OK`        |
| `POST`     | `/v1/auth/signin`     | 유저 로그인 처리 (V1)                  | 없음                   | `{ "email": string }`                   | `{ "bearerToken": string }`                  | 없음                                         | `200 OK`        |
| `POST`     | `/v2/auth/signup`     | 유저 가입 처리 (V2)                    | 없음                   | `{ "email": string }`                   | 없음                                         | `Authorization: Bearer {token}`             | `200 OK`        |
| `POST`     | `/v2/auth/signin`     | 유저 로그인 처리 (V2)                  | 없음                   | `{ "email": string }`                   | 없음                                         | `Authorization: Bearer {token}`             | `200 OK`        |
| `GET`      | `/v1/users`           | 유저 목록 조회                         | 없음                   | 없음                                    | `[ { "email": string } ]`                    | 없음                                         | `200 OK`        |
| `GET`      | `/test`               | 인증 유저 로그 출력                    | 없음                   | 없음                                    | 없음                                         | 없음                                         | `200 OK`        |
