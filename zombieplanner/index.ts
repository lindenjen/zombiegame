//import classes from other files
import { randomEvent } from "./utils/randomEvents";
import { STARTING_SUPPLIES, inventoryArray } from "./config/constants";
import { assignTasks, viewInventory, viewSurvivorStatus, executeDay } from "./classes/actions";
import { checkGameOverConditions } from "./tests/testOutcome";
import { SafeHouse } from "./classes/safeHouse";
import { Survivor } from "./classes/survivor";

//set basic game variables
let day = 1;
let gameIsRunning = true;

//survivor information
const survivors: Survivor[] = [
    new Survivor("Daphne Blake", 5, 10, 8, inventoryArray),
    new Survivor("Jared Goff", 7, 10, 6, inventoryArray)
];
//safehouse information
const safeHouse = new SafeHouse("Downtown", 3, { ...STARTING_SUPPLIES });

//game menu loop
while (gameIsRunning) {
    console.log(`--- Day ${day} ---`);
    console.log("Main Menu:");
    console.log("1. Assign Tasks");
    console.log("2. Check Inventory");
    console.log("3. View Survivor Status");
    console.log("4. Start Day");
    const playerChoice = prompt("Choose an option: ");

    //will either break the game or respond with an action from actions.ts depending on the users choice
    switch (playerChoice) {
        case "1":
            assignTasks(survivors);
            break;
        case "2":
            viewInventory(survivors);
            break;
        case "3":
            viewSurvivorStatus(survivors);
            break;
        case "4":
            console.log("Starting the day...");
            executeDay(safeHouse, survivors);
            break;
        default:
            console.log("Invalid choice. Please select again.");
    }

    //checks conditions if any survivors are alive, if not breaks the loop and displays a message
    if (checkGameOverConditions(safeHouse, survivors)) {
        gameIsRunning = false;
        console.log("Game Over. Thanks for playing!");
    } else {
        day++;
    }
}
