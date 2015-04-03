<img src='http://galenscovell.github.io/css/pics/percolation.png' width=500px />

Percolation
======

This project utilizes the Weighted Quick-Union data structure with Path Compression to determine the ratio of open sites to total sites required for an abstract porous material to percolate.

<b>Description</b>
<blockquote>Given a composite system comprised of randomly distributed insulating and metallic materials: what fraction of the materials need to be metallic so that the composite system is an electrical conductor? Given a porous landscape with water on the surface (or oil below), under what conditions will the water be able to drain through to the bottom (or the oil gush to the surface)? Scientists have defined an abstract process known as <i>percolation</i> to model such situations.</blockquote>

<b>Usage</b>
<blockquote>Run the project from bin/Percolation.jar</blockquote>

<b>Algorithmic Analysis</b>
<blockquote>Each T(N) averaged from 10 runs</blockquote>
<table>
  <tr>
    <td>[N (input size)]</td>
    <td>[T(N) (runtime)]</td>
    <td>[T / previous T (ratio)]</td>
    <td>[Binary Logarithm of ratio]</td>
  </tr>
  <tr>
    <td>10</td>
    <td>0.0017s</td>
    <td>...</td>
    <td>...</td>
  </tr>
  <tr>
    <td>20</td>
    <td>0.0052s</td>
    <td>3.06</td>
    <td>1.61</td>
  </tr>
  <tr>
    <td>40</td>
    <td>0.0335s</td>
    <td>6.44</td>
    <td>2.69</td>
  </tr>
  <tr>
    <td>80</td>
    <td>0.5052s</td>
    <td>15.1</td>
    <td>3.92</td>
  </tr>
  <tr>
    <td>160</td>
    <td>8.0109s</td>
    <td>15.86</td>
    <td>3.99</td>
  </tr>
</table>

<blockquote>lg(N) appears to converge towards 4, so this is my estimate of b (the power law exponent)</blockquote>
<blockquote>We can calculate a (the constant): [T(N) = aN<sup>b</sup>] 8.0109 = a*160<sup>4</sup>, a = 1.2 * 10<sup>-8</sup></blockquote>
<blockquote>My version of Percolation can be approximated with the power law: 1.2*10<sup>-8</sup> * N<sup>4</sup></blockquote>

Clearly, some optimizations are in order!

