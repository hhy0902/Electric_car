# 전기차 충전소 찾기 앱

한국전력 전기차충전소 설치현황 API를 활용해 만든 전기차 충전소 찾기 앱 입니다.

play store : https://play.google.com/store/apps/details?id=org.techtown.electric_car

# 사용 open api 

한국전력 전기차충전소 설치현황 API : https://bigdata.kepco.co.kr/cmsmain.do?scode=S01&pcode=000493&pstate=ev&redirect=Y

한국전력 시도, 시군구 코드 : https://bigdata.kepco.co.kr/cmsmain.do?scode=S01&pcode=000493&pstate=code&redirect=Y

카카오 developer 주소 검색 API : https://developers.kakao.com/docs/latest/ko/local/dev-guide#address-coord

# 사용된 기술 

android studio, kotlin, retrofit2, naver map, recyclerView...

# 동작 과정

시도, 시군구 코드 입력 -> 한국전력 전기차충전소 설치현황 API를 이용해 해당하는 지역의 충전소 리스트 보여주기 -> 

item선택시 카카오 주소 검색 API를 사용해 위도,경도 정보 얻기 -> 가져온 위도,경도 정보로 네이버 지도에 충전소 위치 보여주기 -> 

길찾기 버튼 누르면 naver Directions(길찾기 API)를 사용해 pathLocation값 얻기 -> 

가져온 pathLocation & 네이버 지도의 PathOverlay기능을 사용해 경로 표시하기

# Result

![KakaoTalk_20220708_012022862_05](https://user-images.githubusercontent.com/86578252/177823126-8f80ca2a-74dd-40fe-9a76-abc002731f21.jpg)
![KakaoTalk_20220708_012022862_04](https://user-images.githubusercontent.com/86578252/177823183-bace633e-86a2-4480-b45a-1ad05a18a3bc.jpg)
![KakaoTalk_20220708_012022862_03](https://user-images.githubusercontent.com/86578252/177823364-d4b36b08-4fd5-4d79-b7ea-1e0fec902542.jpg)

