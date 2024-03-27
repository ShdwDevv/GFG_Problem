<h2><a href="https://www.geeksforgeeks.org/problems/number-of-distinct-islands/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=number-of-distinct-islands">Number of Distinct Islands</a></h2><h3>Difficulty Level : Medium</h3><hr><div class="problems_problem_content__Xm_eO" element-id="249"><p element-id="248"><span style="font-size:18px" element-id="247">Given a boolean 2D matrix <strong element-id="246">grid&nbsp;</strong>of size <strong element-id="245">n</strong> * <strong element-id="244">m</strong>. You have to find the number of distinct islands where a group of connected 1s (horizontally or vertically) forms an island. Two islands are considered to be distinct if and only if one island is not equal to another (not rotated or reflected).</span></p>

<p element-id="243"><strong element-id="242"><span style="font-size:18px" element-id="241">Example 1:</span></strong></p>

<pre element-id="240"><span style="font-size:18px" element-id="239"><strong element-id="238">Input:</strong></span>
<span style="font-size:18px" element-id="237">grid[][] = {{1, 1, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {0, 0, 0, 1, 1},
            {0, 0, 0, 1, 1}}</span>
<span style="font-size:18px" element-id="236"><strong element-id="235">Output:</strong></span>
<span style="font-size:18px" element-id="234">1</span>
<span style="font-size:18px" element-id="233"><strong element-id="232">Explanation:</strong></span>
<span style="font-size:18px" element-id="231">grid[][] = {{<span style="color:#ff0000" element-id="230">1</span>, <span style="color:#ff0000" element-id="229">1</span>, 0, 0, 0}, 
&nbsp;           {<span style="color:#ff0000" element-id="228">1</span>, <span style="color:#ff0000" element-id="227">1</span>, 0, 0, 0}, 
&nbsp;           {0, 0, 0, <span style="color:#ff0000" element-id="226">1</span>, <span style="color:#ff0000" element-id="225">1</span>}, 
&nbsp;           {0, 0, 0, <span style="color:#ff0000" element-id="224">1</span>, <span style="color:#ff0000" element-id="223">1</span>}}
Same colored islands are equal.
We have 2 equal islands, so we 
have only 1 distinct island.</span>

</pre>

<p element-id="222"><strong element-id="221"><span style="font-size:18px" element-id="220">Example 2:</span></strong></p>

<pre element-id="219"><span style="font-size:18px" element-id="218"><strong element-id="217">Input:</strong></span>
<span style="font-size:18px" element-id="216">grid[][] = {{1, 1, 0, 1, 1},
&nbsp;           {1, 0, 0, 0, 0},
&nbsp;           {0, 0, 0, 0, 1},
&nbsp;           {1, 1, 0, 1, 1}}</span>
<span style="font-size:18px" element-id="215"><strong element-id="214">Output:</strong></span>
<span style="font-size:18px" element-id="213">3</span>
<span style="font-size:18px" element-id="212"><strong element-id="211">Explanation:
</strong>grid[][] = {{<span style="color:#ff0000" element-id="210">1</span>, <span style="color:#ff0000" element-id="209">1</span>, 0, <span style="color:#00ff00" element-id="208">1</span>, <span style="color:#00ff00" element-id="207">1</span>}, 
&nbsp;           {<span style="color:#ff0000" element-id="206">1</span>, 0, 0, 0, 0}, 
&nbsp;           {0, 0, 0, 0, <span style="color:#0000cd" element-id="205">1</span>}, 
&nbsp;           {<span style="color:#00ff00" element-id="204">1</span>, <span style="color:#00ff00" element-id="203">1</span>, 0, <span style="color:#0000ff" element-id="202">1</span>, <span style="color:#0000ff" element-id="201">1</span>}}</span>
<span style="font-size:18px" element-id="200">Same colored islands are equal.
We have 4 islands, but 2 of them
are equal, So we have 3 distinct islands.</span>

</pre>

<p element-id="199"><span style="font-size:18px" element-id="198"><strong element-id="197">Your Task:</strong></span></p>

<p element-id="196"><span style="font-size:18px" element-id="195">You don't need to read or print anything. Your task is to complete the function <strong element-id="194">countDistinctIslands()&nbsp;</strong>which takes the <strong element-id="193">grid</strong> as an input parameter and returns the total number of <strong element-id="192">distinct</strong> islands.</span></p>

<p element-id="191"><span style="font-size:18px" element-id="190"><strong element-id="189">Expected Time Complexity:&nbsp;</strong>O(n * m)<br element-id="188">
<strong element-id="187">Expected Space Complexity:&nbsp;</strong>O(n * m)</span></p>

<p element-id="186"><span style="font-size:18px" element-id="185"><strong element-id="184">Constraints:</strong><br element-id="183">
1 ≤ n, m ≤ 500<br element-id="182">
grid[i][j] == 0 or grid[i][j] == 1</span></p>

<ul element-id="181">
</ul>
</div><br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>DFS</code>&nbsp;<code>Graph</code>&nbsp;<code>BFS</code>&nbsp;<code>Data Structures</code>&nbsp;<code>Algorithms</code>&nbsp;