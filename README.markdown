# Image Sprite Generator - SpriteGenerator.java
## This is a simple java application for generating sprite images from a folder of PNG images for use in web design or game development.

This is useful in combining multiple images into one image sprite.  I use this to generate sprites for icons used in web applications.  This way only one file needs to be downloaded and cached for every icon in the application.  The original intent for the application was for Android based game development.

I've used it to create the image sprites for [SASSy Silk Icon Sprites mixin][sassy_sprites] among other projects.

This is free software.  Modified for use with CSS sprite by [Mark Young][zarzax_home] from [Peter Moberg][peter_home] SpriteGenerator used for Android game development.

## Usage
    $ javac SpriteGenerator.java
    $ java SpriteGenerator {path to images} {margin between images in px} {output file}

This should generator a SpriteGenerator.class file in the current directory.  You run the application without specifying the '.class' for the file.

## Why vertical?  Or why have margins?
This tool is used by me for CSS image sprites.  These work best as a vertical sprite with space between every image.  This helps in avoiding seeing fragments of other icons when the container is a bit bigger than the 16x16px image.
 

## Notes
The max size of a PNG that works in windows based browsers is 32,767px.  This is because Microsoft GDI stores dimensions in a 16bit integer.  This program will not take this into account and will create arbitrary large PNGs.  You can create about a sprite based around 500 16x16px PNGs with 40px margins between them.

## Having Java Problems?
If you experience any problem like 'Exception in thread "main"' you may have a problem with you %CLASSPAST% environment variable but try:
    $ java -cp . SpriteGenerator



[zarzax_home]: http://www.zarzax.com
[sassy_sprites]: https://github.com/zarzax/sassy-silk-sprites
[peter_home]: http://sourcecodebean.com/archives/a-simple-image-sprite-generator-in-java/1065