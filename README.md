# MetaBus-Clean_Architecture_practice

## 개요

이 프로젝트는 Clean Architecture를 공부하고 실제 프로젝트에 적용해 보기 위한 프로젝트입니다.

강의 ["강사룔의 앱 안정성 및 확장성 강화를 위한 Android 아키텍쳐"](https://fastcampus.co.kr/dev_red_ksr)와 여러 블로그 글들을 참고하여 만들었습니다.

## Specification

| Tech Stack           | Contents                                                     |
| -------------------- | ------------------------------------------------------------ |
| Architecture         | MVVM, Clean Architecture                                     |
| Jetpack              | ViewBinding, ViewModel, lifeCycle                            |
| Dependency Injection | dagger-Hilt                                                  |
| Design Pattern       | Repository Pattern                                           |
| Async                | Coroutine, Coroutine Flow                                    |

## 기능

간단한 기능으로 원하는 정류소의 버스 도착 정보를 볼 수 있는 앱 입니다.

API로는 공공API의 [국토교통부_(TAGO)_버스정류소정보](https://www.data.go.kr/data/15098534/openapi.do)와 [국토교통부_(TAGO)_버스도착정보](https://www.data.go.kr/data/15098530/openapi.do)를 사용하여 도착 정보를 가져왔습니다.

