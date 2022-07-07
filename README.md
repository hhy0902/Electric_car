# 전기차 충전소 찾기 앱

한국전력 전기차충전소 설치현황 API를 활용해 만든 전기차 충전소 찾기 앱 입니다.

# 사용 open api 

한국전력 전기차충전소 설치현황 API : https://bigdata.kepco.co.kr/cmsmain.do?scode=S01&pcode=000493&pstate=ev&redirect=Y

한국전력 시도, 시군구 코드 : https://bigdata.kepco.co.kr/cmsmain.do?scode=S01&pcode=000493&pstate=code&redirect=Y

카카오 developer 주소 검색 API : https://developers.kakao.com/docs/latest/ko/local/dev-guide#address-coord

naver ncp Maps Directions(길찾기 API) : https://api.ncloud-docs.com/docs/ai-naver-mapsdirections

naver ncp Mobile Dynamic Map(지도 API) : https://navermaps.github.io/android-map-sdk/guide-ko/0.html

# 사용된 기술 

retrofit2, naver map, recyclerView...

# 동작 과정

시도, 시군구 코드 입력 -> 한국전력 전기차충전소 설치현황 API를 이용해 해당하는 지역의 충전소 리스트 보여주기 -> 

item선택시 카카오 주소 검색 API를 사용해 위도,경도 정보 얻기 -> 가져온 위도,경도 정보로 네이버 지도에 충전소 위치 보여주기 -> 

길찾기 버튼 누르면 naver Directions(길찾기 API)를 사용해 pathLocation값 얻기 -> 

가져온 pathLocation & 네이버 지도의 PathOverlay기능을 사용해 경로 표시하기
