# MyTetris

> My own game project based on classic tetris game

**Short gameplay**

![Recordit GIF](http://g.recordit.co/cphASQ9DyF.gif)

**Game menu**

[![INSERT YOUR GRAPHIC HERE](https://zapodaj.net/images/aa90b31064cc0.jpg)]()

## Table of Contents

- [Installation](#installation)
- [Features](#features)
- [Example](#example)
- [Contributing](#contributing)
- [Support](#support)
- [License](#license)

## Installation

Download and run java -jar ...\MyTetris\out\artifacts\MyTetris_jar\MyTetris.jar

## Features

> MyTetris app contains actualy following features:

- score table with results

[![INSERT YOUR GRAPHIC HERE](https://zapodaj.net/images/c0d88d24604f6.jpg)]()

- music on/off button

## Example

Implementation of factory design pattern:

```java
private Figure getFigureFromFigureType(FigureType figureType) {
        switch (figureType) {
            case FIGURE_I:
                return new FigureI();
            case FIGURE_L:
                return new FigureL();
            case FIGURE_SQR:
                return new FigureSqr();
            case FIGURE_PLUS:
                return new FigureHalfPlus();
            case FIGURE_STEP:
                return new FigureStep();
        }
        return new FigureI();
    }
```

## Contributing

For any problems, comments, or feedback please create an issue here on GitHub.

## Support

Contact with me on [my webside](https://adasko18.github.io/)

## License

- **[MIT license](http://opensource.org/licenses/mit-license.php)**
-**Free music for non-commercial use from https://www.fesliyanstudios.com**




