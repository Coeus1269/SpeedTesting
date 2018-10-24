# SpeedTesting
<b>Speed testing many processes, loops and structures.</b>

There have been a number of times where me, or someone on my team have asked, "would it be faster to do it this way instead?"
This is a compliation of some of the tests that we built to try and help answer the question.

<b> BigDecimalTest</b>      - speed testing big decimal assignment and retrevial

<b> BooleanSpeedTest</b>    - testing the different ways to test a boolean variable.<br>
We foud no significant speed gain from the various methods we tested.

<b> HashTests </b>          - testing some different hash structures.

<b> IFvsSwitch </b>          - speed testing if else versus a switch or case statement<br>
We found no significant difference. This test showed that in a loop of 100,000, both processed completely in approximately 14ms

<b> TestPaddingSpeed </b>    - speed testing differnt was to left and right pad of a string.

<b> TestStringEqual </b>     - speed testing strimg compares

<b> StringBuildervsStringAdd </b>  - test the speed performance of the String builder append vs String + String <br>
  It turns out that StringBuilder is much more efficient than String + String. We tested only a few different scenarios, all of which proved that SB append was faster than String +.

... and others, more to come
