연습문제 40. 필터링 레코드
================
> 레코드를 정렬하는 것도 도움이 되지만,
필터링을 통해 필요한 것만 출력되도록 할 필요가 있다.
>

> 다음의 데이터 집합이 주어졌다고 가정하자.

| First Name | Last Name | Position          | Separation date |
| :--------- | :-------: | :---------------: | --------------: |
| John       | Johnsin   | Manager | 2016-12-31      |
| Tou        | Xiong     | Software Engineer | 2016-10-15 |
| Michaela | Michaelson | District Manager | 2015-12-19 |
| Jake | Jacobson | Programmer |     |
| Jacquelyn | Jackson | DBA |  |
| Sally | Weber | Web Developer | 2015-12-18 |

> 사용자가 입력한 글자와 First Name 필드와 Last Name 필드의 데이터를 모두 비교하여 사용자가 입력한 글자를 포함하는 모든 레코드를 출력하는 프로그램을 작성하라.
>

## 출력 예
<pre><code>
  Enter a search string : Jac

  Results:
  Name              | Position         | Separation Date
  ------------------------------------------------------
  Jacquelyn Jackson | DBA              |
  Jake Jacobson     | Programmer       |
</code></pre>

## 제약 조건
- 맵 배열이나 연관배열을 사용하여 데이터를 구현할 것


## 도전 과제

- 글자 조회 시 대소문자를 구분하도록 프로그램을 수정해보자.
- Position을 조회하는 옵션을 추가하자.
- Separation date 가 6개월 이상 된 직원을 조회하는 옵션을 추가하자.
- 데이터를 파일에서 읽도록 프로그램을 수정해보자.
