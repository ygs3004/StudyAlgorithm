# [unrated] 귤 고르기 - 138476 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/138476?language=java) 

### 성능 요약

메모리: 91.7 MB, 시간: 44.29 ms

### 구분

코딩테스트 연습 > 연습문제

### 채점결과

Empty

### 문제 설명

<p>경화는 과수원에서 귤을 수확했습니다. 경화는 수확한 귤 중 'k'개를 골라 상자 하나에 담아 판매하려고 합니다. 그런데 수확한 귤의 크기가 일정하지 않아 보기에 좋지 않다고 생각한 경화는 귤을 크기별로 분류했을 때 서로 다른 종류의 수를 최소화하고 싶습니다.</p>

<p>예를 들어, 경화가 수확한 귤 8개의 크기가 [1, 3, 2, 5, 4, 5, 2, 3] 이라고 합시다. 경화가 귤 6개를 판매하고 싶다면, 크기가 1, 4인 귤을 제외한 여섯 개의 귤을 상자에 담으면, 귤의 크기의 종류가 2, 3, 5로 총 3가지가 되며 이때가 서로 다른 종류가 최소일 때입니다.</p>

<p>경화가 한 상자에 담으려는 귤의 개수 <code>k</code>와 귤의 크기를 담은 배열 <code>tangerine</code>이 매개변수로 주어집니다. 경화가 귤 k개를 고를 때 크기가 서로 다른 종류의 수의 최솟값을 return 하도록 solution 함수를 작성해주세요.</p>

<hr>

<h5>제한사항</h5>

<ul>
<li>1 ≤ <code>k</code> ≤ <code>tangerine</code>의 길이 ≤ 100,000</li>
<li>1 ≤ <code>tangerine</code>의 원소 ≤ 10,000,000</li>
</ul>

<hr>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>k</th>
<th>tangerine</th>
<th>result</th>
</tr>
</thead>
        <tbody><tr>
<td>6</td>
<td>[1, 3, 2, 5, 4, 5, 2, 3]</td>
<td>3</td>
</tr>
<tr>
<td>4</td>
<td>[1, 3, 2, 5, 4, 5, 2, 3]</td>
<td>2</td>
</tr>
<tr>
<td>2</td>
<td>[1, 1, 1, 1, 2, 2, 2, 3]</td>
<td>1</td>
</tr>
</tbody>
      </table>
<hr>

<h5>입출력 예 설명</h5>

<p><strong>입출력 예 #1</strong></p>

<ul>
<li>본문에서 설명한 예시입니다.</li>
</ul>

<p><strong>입출력 예 #2</strong></p>

<ul>
<li>경화는 크기가 2인 귤 2개와 3인 귤 2개 또는 2인 귤 2개와 5인 귤 2개 또는 3인 귤 2개와 5인 귤 2개로 귤을 판매할 수 있습니다. 이때의 크기 종류는 2가지로 이 값이 최소가 됩니다.</li>
</ul>

<p><strong>입출력 예 #3</strong></p>

<ul>
<li>경화는 크기가 1인 귤 2개를 판매하거나 2인 귤 2개를 판매할 수 있습니다. 이때의 크기 종류는 1가지로, 이 값이 최소가 됩니다.</li>
</ul>


> 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges