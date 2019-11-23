## Class Diagram
The below diagram shows most relevant classes in the game.
            ![Alt text](https://github.com/nguyensjsu/fa19-202-gangofive/blob/master/images/components.jpg "Class Diagram")

## Activity Diagram
The below activity diagram shows the workflow of the game.
            ![Alt text](https://github.com/nguyensjsu/fa19-202-gangofive/blob/master/images/ActivityDiagram1.png "Activity Diagram")

## Sequence Diagram
The below diagram depicts the various methods invloved when the snake eats a food object.
                ![Alt text](https://github.com/nguyensjsu/fa19-202-gangofive/blob/master/images/eatFoodSequence.jpg "Sequence Diagram(Food consumption)")


The below diagram depicts the various methods invloved in changing the level of th game.
                ![Alt text](https://github.com/nguyensjsu/fa19-202-gangofive/blob/master/images/LevelSeq.png "Sequence Diagram(Level Change)")

##  State machine
The below diagram displays the various states of the game.
                ![Alt text](https://github.com/nguyensjsu/fa19-202-gangofive/blob/master/images/StatemachineDiagram0.png "State machine")
            

## Design Notes
The following design patterns were implemented :


1)Observer : The observer pattern was implemented for acheving multiple functionalities.  

Here SnakeHead is the publisher and MyWorld is the listener. Everytime the snake eats a food object, SnakeHead notifies MyWorld about this event so MyWorld can do the required operations.
                ![Alt text](https://github.com/nguyensjsu/fa19-202-gangofive/blob/master/images/Food_Observer.jpg "Observer Pattern(Food)")


Here LevelController is the publisher and MyWorld is the listener. Every level has certain parameters based on which the certain game elements are added or removed. The change is level is based on the number of food objects consumed by the snake. Everytime the level changes LevelController notifies the MyWorld.
                ![Alt text](https://github.com/nguyensjsu/fa19-202-gangofive/blob/master/images/Level_Observer.jpg "Observer Pattern(Level)")


Here Scorecard is the publisher and LevelController is the listener. A level changes when the snake consumes 7 food objects. Scorecard keeps a track of number of food objects consumed by the snake and notifies LevelController.
                ![Alt text](https://github.com/nguyensjsu/fa19-202-gangofive/blob/master/images/Score_Observer.jpg "Observer Pattern(Score)")


2)State : State pattern is used to implement the different levels of the game. Every level has certain parameters based on which the certain game elements are added or removed. 
                ![Alt text](https://github.com/nguyensjsu/fa19-202-gangofive/blob/master/images/statePattern.jpg "State Pattern")


3)Stratergy : In the game the user has an option to choose between three cities. The food objects change based on the city selected. This has been implemented using stratergy pattern.
                ![Alt text](https://github.com/nguyensjsu/fa19-202-gangofive/blob/master/images/Strategy_Pattern.jpg "Strategy Pattern")


4)Factory : Factory pattern is used to create different types of food, obstacles and powerup objects.
                ![Alt text](https://github.com/nguyensjsu/fa19-202-gangofive/blob/master/images/factory_pattern.jpg "Factory Pattern")

5)Decorator : Decorator pattern has been used to center align the text in the leaderboard screen.
                ![Alt text](https://github.com/nguyensjsu/fa19-202-gangofive/blob/master/images/decorator_pattern.png "Decorator Pattern")


