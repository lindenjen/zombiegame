//defines the starting supplies and the unused possible zombie types that will impact the game
export const STARTING_SUPPLIES = { food: 10, water: 10, medicine: 5 };
export const ZOMBIE_TYPES = ["Walker", "Runner", "Crawler"];
const inventoryObject = {
    food: 10,
    water: 10,
    medicine: 5
};
export const inventoryArray = Object.entries(inventoryObject); // [['food', 10], ['water', 10], ['medicine', 5]]

