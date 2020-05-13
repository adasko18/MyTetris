# MyTetris

> Game based on classic tetris game

**Short gameplay**

![Recordit GIF](http://g.recordit.co/cphASQ9DyF.gif)

## Table of Contents

- [Installation](#installation)
- [Features](#features)
- [Example](#example)
- [Contributing](#contributing)
- [Support](#support)
- [License](#license)

## Installation

## Features

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

## Support

## License



