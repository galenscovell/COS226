<img src='http://galenscovell.github.io/css/pics/percolation.png' width=500px />

Percolation
======

This project utilizes the Weighted Quick-Union data structure with Path Compression to determine the ratio of open sites to total sites required for an abstract porous material to percolate.

<b>Description</b>
<blockquote>Given a composite system comprised of randomly distributed insulating and metallic materials: what fraction of the materials need to be metallic so that the composite system is an electrical conductor? Given a porous landscape with water on the surface (or oil below), under what conditions will the water be able to drain through to the bottom (or the oil gush to the surface)? Scientists have defined an abstract process known as <i>percolation</i> to model such situations.</blockquote>

<b>Usage</b>
<blockquote>Run the project from bin/Percolation.jar</blockquote>

<b>Original Algorithm Analysis</b>
<table>
  <tr>
    <td>N</td>
    <td>T(N)</td>
    <td>T(N)/previous T(N)</td>
    <td>Binary Logarithm of ratio</td>
    <td>P*</td>
  </tr>
  <tr>
    <td>10</td>
    <td>0.0016s</td>
    <td>...</td>
    <td>...</td>
    <td>0.602</td>
  </tr>
  <tr>
    <td>20</td>
    <td>0.0031s</td>
    <td>1.938</td>
    <td>0.95</td>
    <td>0.585</td>
  </tr>
  <tr>
    <td>40</td>
    <td>0.0313s</td>
    <td>10.097</td>
    <td>3.34</td>
    <td>0.591</td>
  </tr>
  <tr>
    <td>80</td>
    <td>0.4820s</td>
    <td>15.399</td>
    <td>3.94</td>
    <td>0.593</td>
  </tr>
  <tr>
    <td>160</td>
    <td>6.9981s</td>
    <td>14.519</td>
    <td>3.86</td>
    <td>0.597</td>
  </tr>
</table>
<blockquote>Power Law: T(N) = aN<sup>b</sup></blockquote>

* lg(N) converges towards 4, our estimate of b (power law exponent)
* We can calculate a (the constant): 6.9981 = a*160<sup>4</sup>, a = (1.0 * 10<sup>-8</sup>)

<blockquote>This version of Percolation can be approximated with the power law: <b>(1.0 * 10<sup>-8</sup>) * N<sup>4</sup></b></blockquote>

<b>Optimized Algorithm Analysis</b>
<blockquote>There are some areas we can optimize in the original algorithm. The time limiting factor in the process is the randomized site opening which only opens one site per loop. If N is very large, one open site is a drop in the bucket and leads to very slow percolation.<br>One way we could speed up this process is by allowing more open sites during each loop depending on the size of N. In this optimized process, ((N * N) / 100) sites are opened each loop; if N is 10, 1 site is opened per loop, but if N is 640 then 4096 sites are opened per loop. This has little impact on the calculated values of P* due to the vast size of the grid (N * N).</blockquote>
<table>
  <tr>
    <td>N</td>
    <td>T(N)</td>
    <td>T(N)/previous T(N)</td>
    <td>Binary Logarithm of ratio</td>
    <td>P*</td>
  </tr>
  <tr>
    <td>10</td>
    <td>0.003s</td>
    <td>...</td>
    <td>...</td>
    <td>0.608</td>
  </tr>
  <tr>
    <td>20</td>
    <td>0.003s</td>
    <td>1.00</td>
    <td>0</td>
    <td>0.610</td>
  </tr>
  <tr>
    <td>40</td>
    <td>0.005s</td>
    <td>1.67</td>
    <td>0.74</td>
    <td>0.604</td>
  </tr>
  <tr>
    <td>80</td>
    <td>0.014s</td>
    <td>2.80</td>
    <td>1.49</td>
    <td>0.594</td>
  </tr>
  <tr>
    <td>160</td>
    <td>0.039s</td>
    <td>2.79</td>
    <td>1.48</td>
    <td>0.601</td>
  </tr>
  <tr>
    <td>320</td>
    <td>0.146s</td>
    <td>3.74</td>
    <td>1.90</td>
    <td>0.597</td>
  </tr>
  <tr>
    <td>640</td>
    <td>0.658s</td>
    <td>4.51</td>
    <td>2.17</td>
    <td>0.598</td>
  </tr>
</table>
<blockquote>Power Law: T(N) = aN<sup>b</sup></blockquote>

* lg(N) converges towards 2, our estimate of b (power law exponent)
* We can calculate a (the constant): 0.658 = a*640<sup>2</sup>, a = (1.6 * 10<sup>-6</sup>)

<blockquote>The optimized version of Percolation can be approximated with the power law: <b>(1.6 * 10<sup>-6</sup>) * N<sup>2</sup></b><br>This version is two orders of magnitude more efficient than the original and is able to process far larger input sizes due to the increase in performance.</blockquote>
