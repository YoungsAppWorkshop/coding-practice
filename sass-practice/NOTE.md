# SASS Crash Course

### Let SASS automatically watch `.scss` file
```bash
└── root
    ├── css
    │   ├── styles.css
    │   └── styles-admin.css
    └── scss
        ├── partials
        │   ├── ...
        │   └── _mixins.scss
        ├── styles.scss
        └── styles-admin.scss
```
In terminal, in the root directory,
* By default, CSS style is expanded: `sass --watch sass:css`
* For compressed CSS style: `sass --watch sass:css --style compressed`

### Variables
```scss
$primary-color: #000;
.first-class {
    color: $primary-color;
    font-family: sans-serif;
    text-decoration: underline;
}
```


### Extending Classes
```scss
.second-class {
    @extend .first-class;
    border-color: #fff;
}
```


### Nesting Classes
```scss
a { font-family: sans-serif; color: $primary-color;
    &:hover,
    &.focus,
    &:active { color: blue; }
    &.link-class { color: green;
        &:hover,
        &.focus,
        &:active { color: blue; }
    }
}
```


### Functions
```scss
@function half-height($first, $second) {
    @return $container / $first + $padding / $second;
}
.half {
    height: half-height(2, 2);
}
```


### Mixins
```scss
@mixin translateX( $val ) {
    -webkit-transform: translateX($val);
    -moz-transform: translateX($val);
    -ms-transform: translateX($val);
    -o-transform: translateX($val);
    transform: translateX($val);
}
.translateX {
    @include translateX(15px);
}
// Defining default value as 320ms
@mixin animate-time ($time: 320ms) {
  -webkit-transition: $time ease;
  -moz-transition: $time ease;
  -ms-transition: $time ease;
  -o-transition: $time ease;
  transition: $time ease;
}
.box1 {
  @include animate-time;
}
.box2 {
  @include animate-time(500ms);
}
```


### Partials and Import

Create partials like `partials/_mixins.scss`, and import in `styles.scss` file

```scss
@import 'partials/reset';
```


### Loop
* For loop
```scss
// @for $var from <start> through <end>
@for $space from 1 through 6
{
    // Using SASS built-in function, percentage()
    $width: percentage( 1 / $space );
    .colume-#{$space}
    {
      width: $width;
    }
}
```

* While loop
```scss
// @while $var something int
$num: 6;
@while $num > 0
{
    $width: percentage( 1 / $num );
    .colume-#{$num}
    {
      width: $width ;
    }
    $num: $num - 1;
}
```

* Each loop
```scss
// Want something like these lines:
//    .text-white { color: #FFF; }
//    .text-black { color: #000; }
$white: #FFF;
$black: #000;
$red: #F00;
$primary: #CCC;
$secondary: #333;
// Define colors array
$colours: (
    'white': $white,
    'black': $black,
    'red': $red,
    'primary': $primary,
    'secondary': $secondary
);
// @each key, value in array {}
@each $colour, $hex in $colours
{
    .text-#{$colour}
    {
      color: $hex;
    }
}
```
