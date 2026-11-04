//////////////////////////
// Gut zu wissen und so //
//////////////////////////

// FXML
Describes
    Layout:     which buttons, labels, and
                containers exist, and where

// CONTROLLER
Describes
    Behavior:   what happens when something
                is clicked, typed, or changes

e.g: Seperate them -> shop, main menu, pause menu, game over screen
                for Whole Screen stuff
                    repeated elements

    Canva/ Code, not FXML for simple labels, game-Objects, player, enemies, pickups?

EXAMPLE with Code:

    Button btn = new Button("Press Me");
    VBox componentGroup = new VBox();
    componentGroup.setAlignment(Pos.CENTER);
    componentGroup.setSpacing(20);
    componentGroup.getChildren().add(btn);