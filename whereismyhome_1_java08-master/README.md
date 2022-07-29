# WhereIsMyHome_1_Java_08조_박상민_이재혁

### 📌 구현한 기능

1. searchBt Lambda 식으로 표현하여 이벤트 연결

2. search() 를 Dao Layer의 Method를 호출하도록 구현

3. 화면 목록에서 선택된 항목 번호로 상세 정보를 얻어 HomeDeal 객체로 return하도록 구현

4. ARTRentSAXHandler 의 부분 코드를 완성

5. HomeDealSAXHandler 의 전체 코드를 완성

6. 부산 동래구의 학교정보 csv 파일을 파싱하여 Dto를 구성하여 데이터를 객체화

7. 서울시 종로구의 상권정보 csv 파일을 파싱하여 Dto를 구성하여 데이터를 객체화

8. 프로그램 실행 시 3가지의 서비스클래스의 객체를 만듬과 동시에 데이터파일을 파싱하여 각각의 Dao 객체에 저장 -> 서비스 객체를 통해 Dao 객체에 저장된 데이터들을 가져올 수 있도록 구조를 설계하여 구현

9. 별도로 2개의 버튼을 추가해 현재 선택된 집의 동 기준으로 학교정보와 상권정보를 조회할 수 있도록 구현

10. 데이터 파싱 중 데이터의 손실로 인해 동정보를 얻지 못하여 nullPointerException 이 발생할 때 try-catch 문을 사용하여 해결
 
---

### 📌 프로그램 실행화면
![first](/uploads/aa5afaf08bfbeadf091c6dd4ef0b3893/first.PNG) - 초기 화면
![check_box](/uploads/e9a3f984be99ec80a3c3679458461594/check_box.PNG) - 주거 계약형태를 Check_Box를 통해 필터링  
![location](/uploads/4e48c472550ee8e1a286f68a4fb762db/location.PNG) - Drop_Down_List를 이용하여 동 기준으로 필터링  
![Stringcontain](/uploads/a31c3d8a2196d0f5569ede4ea7c91052/Stringcontain.PNG) - Drop_Down_List를 이용하여 아파트 및 주택이름에 포함된 문자로 필터링
![nearschool](/uploads/12127f0ff7c1ff34706bd7caf1e33dc2/nearschool.PNG) - 마우스를 통해 선택된 Row의 동 기준 주변 학교 정보를 보여주는 기능
![infra](/uploads/be609c4a3d5f0ee4d73951c895588b5e/infra.PNG) - 마우스를 통해 선택된 Row의 동 기준 주변 상권 정보를 보여주는 기능
