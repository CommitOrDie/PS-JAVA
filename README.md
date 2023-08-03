# [JAVA] 코딩 테스트 대비 알고리즘 문제 풀이

### 복습할 문제
- BFS
  - 4179
  - 2206(벽부수기)
- 재귀
  - 1629(곱셈)
### 순열
- N 개 중에서 M 개를 중복없이 뽑는다.
```java
	// 순열
    private static void permutation(int cnt) {
        if (cnt == m) {
            System.out.println(Arrays.toString(arr));
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[cnt] = i;
                permutation(cnt + 1);
                visited[i] = false;
            }
        }
    }
    
    // 중복 순열 - 중복 제거하는 visited를 쓰지 않음
    private static void repeatedPermutation(int cnt) {
        if (cnt == m) {
            System.out.println(Arrays.toString(arr));
            return;
        }
        for (int i = 1; i <= n; i++) {
            arr[cnt] = i;
            permutation(cnt + 1);
        }
    }
```
### 조합
```java
// 조합
    private static void combination(int cnt, int start) {
        if (cnt == m) {
            System.out.println(Arrays.toString(arr));
            return;
        }
        for (int i = start; i <= n; i++) {
            arr[cnt] = i;
            combination(cnt + 1, i + 1); // 오름차순으로 구하면 중복 체크하지 않아도 됨
        }
    }

    // 중복 조합
    private static void repeatedCombination(int cnt, int start) {
        if (cnt == m) {
            System.out.println(Arrays.toString(arr));
            return;
        }
        for (int i = start; i <= n; i++) {
            arr[cnt] = i;
            combination(cnt + 1, i); // 중복 허용하니까 비내림차순
        }
    }
결과
```
 
### ArrayList에 중복없이 넣는 방법
```java
If( list.indexOf(value) < 0 ) list.add(value);
```
- indexOf을 사용한다
### 배열과 List
```java
//arr to list
List list = Arrays.asList(arr);//X
//arr to list
List<String> list = new ArrayList<>(Arrays.asList(arr)); //이런식으로 새로 생성해야 변경전파가 안됨
//list to arr
ArrayList<Integer> list = new ArrayList<>();
Integer arr[] = list.toArray(new Integer[2]);

```
### 정렬을 위한 Comparator 함수를 람다로 대체하자
```java
Collections.sort(arr, (a, b) -> b.cost - a.cost);
PriorityQueue<Integer> q = new PriorityQueue<>((o1,o2) -> o2 - o1);
```
### BFS의 시간복잡도, 공간복잡도 확인
- BFS는 1번씩만 방문하므로 예를들어 rxcxh의 배열에 대해 BFS를 수행하면 시간복잡도, 공간복잡도 모두 RxCxH입니다 (공간복잡도 에서는 저만큼을 저장할 배열이 필요하기때문)
- BFS에서는 1번씩만 방문하도록 큐에 잘 집어넣는것이 중요(중복된 값이 여러번 들어가면 시간초과와 같은 다양한 문제가 생김)

### 2206 벽부수기에서 visited하나만 있으면 안되는이유
- 예를 들어 벽을 일찍 부수고 이전에 방문하지 않은 셀을 통과하면 더 빨리 도착하는 경로가 있을 수 있고,
  일부 셀을 먼저 방문한 다음 벽을 부수면 더 빨리 도착하는 경로가 있을 수 있다.
- 하나의 visit[][]만 사용한 경우 상태를 덮어쓰고 하나의 잠재적 경로를 잃을 수 있다.

### 큰수의 나머지를 입력하세요
- 알고리즘 문제를 푸는 과정에서 결과 값이 매우 큰 경우, 결과 값의 나머지를 구하라는 문제가 자주 등장한다.
- 단순히 결과 값에 모듈러 연산을 수행할 시 이미 결과 값은 너무 커져서 오버플로우가 발생한 경우가 대부분이기 때문에, 연산 과정 도중에 모듈러 연산을 적용해야 한다.
- 연산 과정 도중에 모듈러 연산을 적용하려면 모듈러 연산의 분배법칙에 대해 알아야 한다.
- 각 피연산자에 모듈러 연산을 취한 후, 계산 결과에 대해 다시한번 모듈러 연산을 취하면 된다. 또한, 뺄셈의 경우 음수가 나오는 것을 방지하기 위해 divisor를 한번 더해준다.
```
(A + B) % p = ((A % p) + (B % p)) % p
(A * B) % p = ((A % p) * (B % p)) % p
(A - B) % p = ((A % p) - (B % p) + p) % p
```
### 입출력 시간 비교
- with 2448
1. BufferedWriter사용하여 o(n^2)의 출력 수행하기
```java
        for (int i = n-1; i >= 0; i--) {
            for (int j = 2*n-2; j >= 0; j--) {
                bw.write(result[i][j]+"");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
```
2. StringBuilder + System.out.println() 사용해서 출력 수행하기
```java
        StringBuilder sb = new StringBuilder();
        for (int i = n-1; i >= 0; i--) {
            for (int j = 2*n-2; j >= 0; j--) {
                sb.append(result[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
```
- 메모리와 시간 비교(출력부분만 변경한것임)
- ![image](https://github.com/CommitOrDie/PS-JAVA/assets/66842566/13631ad6-26af-47a3-a8ee-21c80f456990)


---
참고
https://velog.io/@yul_00/AlgorithmJava-%EC%88%9C%EC%97%B4%EA%B3%BC-%EC%A1%B0%ED%95%A9





