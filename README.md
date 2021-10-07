# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)


##요구사항
[ ] N대의 자동차의 이름은 쉼표 단위로 입력 받는다. (이름은 5자 이하여야 한다.)
[x] [예외] 이름이 5자를 초과할 경우,  
[x] [예외] 이름없이 ,만 존재하거나, 이름이 정상적으로 이루어지지 않았을 경우

[ ] 경주를 시도할 횟수를 입력 받는다.
[x] [예외] 횟수가 양의 정수가 아닌 경우
[ ] 전진 조건은 %10 의 값을 구한 후 4 이상 전진, 3 이하는 전진하지 않는다.  
[ ] 실행결과를 다음과 같이 표기한다.  
  실행 결과 ( 최초 1회만 )  
  {carName} : {-}   (-은 전진한 횟수만큼 출력)
