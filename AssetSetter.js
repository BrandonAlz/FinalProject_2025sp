import OBJ_Door from '../objects/OBJ_Door.js';
import OBJ_Key from '../objects/OBJ_Key.js';
import OBJ_Chest from '../objects/OBJ_Chest.js';
import OBJ_Hotdog from '../objects/OBJ_Hotdog.js';
import OBJ_WoodenStaff from '../objects/OBJ_WoodenStaff.js';  // Add this
import OBJ_LeatherRobe from '../objects/OBJ_LeatherRobe.js';   // Add this
import OBJ_RobeOfElders from '../objects/OBJ_RobeOfElders.js';
import OBJ_StaffOfTrees from '../objects/OBJ_StaffOfTrees.js';
import NPC_OldMan from '../NPC.js';
import MON_GreenSlime from '../monster/MON_GreenSlime.js';
import MON_ShootingSlime from '../monster/MON_ShootingSlime.js';
import { mapConnections } from './MapConnections.js';
import OBJ_Tree from '../objects/OBJ_Tree.js';
import OBJ_SnowTree from '../objects/OBJ_SnowTree.js';
import { TILE_TYPES } from '../TileTypes.js';
import OBJ_RedDoor from '../objects/OBJ_RedDoor.js';
import OBJ_BlueDoor from '../objects/OBJ_BlueDoor.js';
import OBJ_GreenDoor from '../objects/OBJ_GreenDoor.js';
import OBJ_PurpleDoor from '../objects/OBJ_PurpleDoor.js';
import OBJ_BlueKey from '../objects/OBJ_BlueKey.js';
import OBJ_GreenKey from '../objects/OBJ_GreenKey.js';
import OBJ_PurpleKey from '../objects/OBJ_PurpleKey.js';
import OBJ_RedKey from '../objects/OBJ_RedKey.js';
import UP_Arrow from '../objects/UP_Arrow.js';
import DOWN_Arrow from '../objects/DOWN_Arrow.js';
import MON_FinalBoss from '../monster/MON_FinalBoss.js';

export default class AssetSetter {
    constructor(gp) {
        this.gp = gp;
        
        // Define map configurations
        this.mapSetups = {
            "0": {  // First map
                monsters: [
                    { type: "slime", x: 15, y: 14 },
                    { type: "slime", x: 11, y: 11 }
                ],
                objects: [
                    //{ type: "key", x: 5, y: 8 }, // Generic key (if you still use it)
                    { type: "hotdog", x: 20, y: 18 },
                    { type: "hotdog", x: 15, y: 15 },
                    { type: "chest", x: 9, y: 9 },
                    { type: "woodenStaff", x: 7, y: 7 },
                    { type: "leatherRobe", x: 8, y: 7 },
                    { type: "robeOfElders", x: 10, y: 7 },
                    { type: "staffOfTrees", x: 12, y: 7 },
                    { type: "Red Door", x: 10, y: 10, requiredKey: "red" },
                    { type: "Blue Door", x: 11, y: 11, requiredKey: "blue" },
                    { type: "Green Door", x: 12, y: 12, requiredKey: "green" },
                    { type: "Purple Door", x: 13, y: 13, requiredKey: "purple" },
                    { type: "Red Key", x: 14, y: 14, color: "red" },
                    { type: "Blue Key", x: 15, y: 15, color: "blue" },
                    { type: "Green Key", x: 16, y: 16, color: "green" },
                    { type: "Purple Key", x: 17, y: 17, color: "purple" }
                ],
                trees: [
                    { x: 14, y: 5 },
                    { x: 13, y: 1 }, 
                    { x: 12, y: 1 }, 
                    { x: 13, y: 2 }, 
                    { x: 37, y: 7 }, 
                    { x: 36, y: 8 }, 
                    { x: 34, y: 7 },
                    { x: 28, y: 8 }, 
                    { x: 14, y: 1 }, 
                    { x: 1, y: 12 }, 
                    { x: 2, y: 13 }, 
                    { x: 1, y: 14 },
                    { x: 10, y: 19 }, 
                    { x: 11, y: 19 }, // Individual tree
                    { range: { startX: 15, endX: 37, startY: 1, endY: 5 } }, // First batch of trees
                    { range: { startX: 25, endX: 30, startY: 10, endY: 15 } },
                    { range: { startX: 1, endX: 9, startY: 15, endY: 19 } }, // Second batch of trees
                    { x: 14, y: 5 }, // Individual tree
                    { range: { startX: 15, endX: 37, startY: 1, endY: 5 } }, // Batch of trees
                    { randomRange: { startX: 10, endX: 20, startY: 5, endY: 15, count: 10 } }, // Random trees
                   // Random Snow Trees
                ],
                npcs: [
                    { type: "oldman", x: 5, y: 5 }
                ]
            },  
            "1": {  
                monsters: [
                    { type: "slime", x: 20, y: 5 },
                    { type: "slime", x: 13, y: 11 },
                    { type: "slime", x: 34, y: 12 }
                ],
                trees: [
                    
                    { randomRange: { startX: 5, endX: 15, startY: 10, endY: 20, count: 15 } }
                ],
                objects: [
                    { type: "hotdog", x: 22, y: 12 },
                    { type: "chest", x: 28, y: 14 }
                ]
            },  
            "2": {  // Third map
                monsters: [
                    { type: "slime", x: 20, y: 5 },
                    { type: "slime", x: 14, y: 11 },
                    { type: "slime", x: 34, y: 12 }
                ],

                trees: [
                    
                    { randomRange: { startX: 5, endX: 38, startY: 4, endY: 18, count: 15 } }
                ],
                
                objects: [
                    { type: "hotdog", x: 22, y: 12 },
                    { type: "chest", x: 28, y: 14 }
                ]
            },
            "3": {  
                monsters: [
                    { type: "slime", x: 20, y: 5 },
                    { type: "slime", x: 13, y: 11 },
                    { type: "slime", x: 34, y: 12 }
                ],
                trees: [
                    
                    { randomRange: { startX: 5, endX: 38, startY: 4, endY: 18, count: 15 } }
                ],
                objects: [
                    { type: "hotdog", x: 22, y: 12 },
                    { type: "chest", x: 28, y: 14 }
                ]
            },  
            "4": {  
                monsters: [
                    { type: "slime", x: 20, y: 5 },
                    { type: "slime", x: 13, y: 11 },
                    { type: "slime", x: 34, y: 12 }
                ],
                trees: [
                    
                    { randomRange: { startX: 5, endX: 38, startY: 4, endY: 18, count: 15 } }
                ],
                objects: [
                    { type: "hotdog", x: 22, y: 12 },
                    { type: "chest", x: 28, y: 14 }
                ]
            },  
            "5": {  
                monsters: [
                    { type: "slime", x: 20, y: 5 },
                    { type: "slime", x: 13, y: 11 },
                    { type: "slime", x: 34, y: 12 }
                ],
                trees: [
                    
                    { randomRange: { startX: 5, endX: 38, startY: 4, endY: 18, count: 15 } }
                ],
                objects: [
                    { type: "hotdog", x: 22, y: 12 },
                    { type: "chest", x: 28, y: 14 }
                ]
            },  
            "6": {  
                monsters: [
                    { type: "slime", x: 20, y: 5 },
                    { type: "slime", x: 13, y: 11 },
                    { type: "slime", x: 34, y: 12 }
                ],
                trees: [
                    
                    { randomRange: { startX: 5, endX: 38, startY: 4, endY: 18, count: 15 } }
                ],
                objects: [
                    { type: "hotdog", x: 22, y: 12 },
                    { type: "chest", x: 28, y: 14 }
                ]
            },  
            "7": {  
                monsters: [
                    { type: "slime", x: 20, y: 5 },
                    { type: "slime", x: 13, y: 11 },
                    { type: "slime", x: 34, y: 12 }
                ],
                trees: [
                    
                    { randomRange: { startX: 5, endX: 38, startY: 4, endY: 18, count: 15 } }
                ],
                objects: [
                    { type: "hotdog", x: 22, y: 12 },
                    { type: "chest", x: 28, y: 14 }
                ]
            },  
            "8": {  
                monsters: [
                    { type: "slime", x: 20, y: 5 },
                    { type: "slime", x: 13, y: 11 },
                    { type: "slime", x: 34, y: 12 }
                ],
                trees: [
                    
                    { randomRange: { startX: 5, endX: 38, startY: 4, endY: 18, count: 15 } }
                ],
                objects: [
                    { type: "hotdog", x: 22, y: 12 },
                    { type: "chest", x: 28, y: 14 }
                ]
            },  
            "9": {  
                monsters: [
                    { type: "slime", x: 20, y: 5 },
                    { type: "slime", x: 13, y: 11 },
                    { type: "slime", x: 34, y: 12 }
                ],
                trees: [
                    
                    { randomRange: { startX: 5, endX: 38, startY: 4, endY: 18, count: 15 } }
                ],
                objects: [
                    { type: "hotdog", x: 22, y: 12 },
                    { type: "chest", x: 28, y: 14 }
                ]
            },  
            "10": {  
                monsters: [
                    { type: "slime", x: 20, y: 5 },
                    { type: "slime", x: 13, y: 11 },
                    { type: "slime", x: 34, y: 12 }
                ],
                trees: [
                    
                    { randomRange: { startX: 5, endX: 15, startY: 10, endY: 20, count: 15 } }
                ],
                objects: [
                    { type: "hotdog", x: 22, y: 12 },
                    { type: "chest", x: 28, y: 14 }
                ]
            },  
            "11": {  
                monsters: [
                    { type: "slime", x: 20, y: 5 },
                    { type: "slime", x: 13, y: 11 },
                    { type: "slime", x: 34, y: 12 }
                ],
                trees: [
                    
                    { randomRange: { startX: 5, endX: 15, startY: 10, endY: 20, count: 15 } }
                ],
                objects: [
                    { type: "hotdog", x: 22, y: 12 },
                    { type: "chest", x: 28, y: 14 }
                ]
            },  
            "12": {  
                monsters: [
                    { type: "slime", x: 20, y: 5 },
                    { type: "slime", x: 13, y: 11 },
                    { type: "slime", x: 34, y: 12 }
                ],
                trees: [
                    
                    { snowRange: { startX: 5, endX: 10, startY: 5, endY: 10 } }, // Batch of Snow Trees
                    { snowRandomRange: { startX: 15, endX: 25, startY: 10, endY: 20, count: 5 } }
                ],
                objects: [
                    { type: "hotdog", x: 22, y: 12 },
                    { type: "chest", x: 28, y: 14 }
                ]
            },  
            "13": {  
                monsters: [
                    { type: "slime", x: 20, y: 5 },
                    { type: "slime", x: 13, y: 11 },
                    { type: "slime", x: 34, y: 12 }
                ],
                trees: [
                    
                    { snowRange: { startX: 5, endX: 10, startY: 5, endY: 10 } }, // Batch of Snow Trees
                    { snowRandomRange: { startX: 15, endX: 25, startY: 10, endY: 20, count: 5 } }
                ],
                objects: [
                    { type: "hotdog", x: 22, y: 12 },
                    { type: "chest", x: 28, y: 14 }
                ]
            },  
            "14": {  
                monsters: [
                    { type: "slime", x: 20, y: 5 },
                    { type: "slime", x: 13, y: 11 },
                    { type: "slime", x: 34, y: 12 }
                ],
                trees: [
                    
                    { snowRange: { startX: 5, endX: 10, startY: 5, endY: 10 } }, // Batch of Snow Trees
                    { snowRandomRange: { startX: 15, endX: 25, startY: 10, endY: 20, count: 5 } }
                ],
                objects: [
                    { type: "hotdog", x: 22, y: 12 },
                    { type: "chest", x: 28, y: 14 }
                ]
            },  
            "15": {  
                monsters: [
                    { type: "slime", x: 20, y: 5 },
                    { type: "slime", x: 13, y: 11 },
                    { type: "slime", x: 34, y: 12 }
                ],
                trees: [
                    
                    { snowRange: { startX: 5, endX: 10, startY: 5, endY: 10 } }, // Batch of Snow Trees
                    { snowRandomRange: { startX: 15, endX: 25, startY: 10, endY: 20, count: 5 } }
                ],
                objects: [
                    { type: "hotdog", x: 22, y: 12 },
                    { type: "chest", x: 28, y: 14 }
                ]
            },
            "16": {  
                monsters: [
                    { type: "slime", x: 20, y: 5 },
                    { type: "slime", x: 13, y: 11 },
                    { type: "slime", x: 34, y: 12 }
                ],
                trees: [
                    
                    { snowRange: { startX: 5, endX: 10, startY: 5, endY: 10 } }, // Batch of Snow Trees
                    { snowRandomRange: { startX: 15, endX: 25, startY: 10, endY: 20, count: 5 } }
                ],
                objects: [
                    { type: "hotdog", x: 22, y: 12 },
                    { type: "chest", x: 28, y: 14 }
                ]
            }, 
            "17": {  
            monsters: [
                { type: "slime", x: 20, y: 5 },
                { type: "slime", x: 13, y: 11 },
                { type: "slime", x: 34, y: 12 }
            ],
            trees: [
                
                { snowRange: { startX: 5, endX: 10, startY: 5, endY: 10 } }, // Batch of Snow Trees
                { snowRandomRange: { startX: 15, endX: 25, startY: 10, endY: 20, count: 5 } }
            ],
            objects: [
                { type: "hotdog", x: 22, y: 12 },
                { type: "chest", x: 28, y: 14 }
            ]
        },
           "18": {  
                monsters: [
                    { type: "slime", x: 20, y: 5 },
                    { type: "slime", x: 13, y: 11 },
                    { type: "slime", x: 34, y: 12 }
                ],
                trees: [
                    
                    { snowRange: { startX: 5, endX: 10, startY: 5, endY: 10 } }, // Batch of Snow Trees
                    { snowRandomRange: { startX: 15, endX: 25, startY: 10, endY: 20, count: 5 } }
                ],
                objects: [
                    { type: "hotdog", x: 22, y: 12 },
                    { type: "chest", x: 28, y: 14 }
                ]
            },     
            "20": {  
                monsters: [
                ],
                objects: [
                    { type: "Green Door", x: 18, y: 6, requiredKey: "green"  },
                    { type: "Green Door", x: 19, y: 6, requiredKey: "green"  },

                    { type: "Blue Door", x: 18, y: 10, requiredKey: "blue"  },
                    { type: "Blue Door", x: 19, y: 10, requiredKey: "blue"  },

                    { type: "Red Door", x: 18, y: 14, requiredKey: "red"  },
                    { type: "Red Door", x: 19, y: 14, requiredKey: "red"  },

                    { type: "Purple Door", x: 18, y: 18, requiredKey: "purple"  },
                    { type: "Purple Door", x: 19, y: 18, requiredKey: "purple"  }
                ]
            },  
            "21": {  
                monsters: [
                    { type: "Final Boss", x: 10, y: 8 }
                ],
                objects: [
                ]
            }  
        };
    }
    addRandomTreesInRange(mapNum, startX, endX, startY, endY, treeCount) {
        const availableTiles = [];
    
        // Collect all available tiles in the given range
        for (let x = startX; x <= endX; x++) {
            for (let y = startY; y <= endY; y++) {
                const tileNum = this.gp.tileM.mapTileNum[mapNum]?.[x]?.[y];
                if (tileNum === TILE_TYPES.GRASS || tileNum === TILE_TYPES.SNOW) {
                    availableTiles.push({ x, y });
                } else {
                    console.log(`Skipping tile at (${x}, ${y}) with tileNum: ${tileNum}`);
                }
            }
        }
    
        // Ensure `this.gp.obj[mapNum]` is initialized
        if (!this.gp.obj[mapNum]) {
            this.gp.obj[mapNum] = [];
        }
    
        // Randomly select tiles to place trees
        for (let i = 0; i < treeCount && availableTiles.length > 0; i++) {
            const randomIndex = Math.floor(Math.random() * availableTiles.length);
            const { x, y } = availableTiles.splice(randomIndex, 1)[0]; // Remove selected tile
    
            console.log(`Placing random tree at map ${mapNum}, x: ${x}, y: ${y}`);
            const tree = new OBJ_Tree();
            tree.x = x * this.gp.tileSize;
            tree.y = y * this.gp.tileSize;
            this.gp.obj[mapNum].push(tree);
        }
    }
    addRandomSnowTreesInRange(mapNum, startX, endX, startY, endY, treeCount) {
        const availableTiles = [];

        // Collect all available tiles in the given range
        for (let x = startX; x <= endX; x++) {
            for (let y = startY; y <= endY; y++) {
                const tileNum = this.gp.tileM.mapTileNum[mapNum]?.[x]?.[y];
                if (tileNum === TILE_TYPES.GRASS || tileNum === TILE_TYPES.SNOW) {
                    availableTiles.push({ x, y });
                } else {
                    console.log(`Skipping tile at (${x}, ${y}) with tileNum: ${tileNum}`);
                }
            }
        }

        if (!this.gp.obj[mapNum]) {
            this.gp.obj[mapNum] = [];
        }

       
        for (let i = 0; i < treeCount && availableTiles.length > 0; i++) {
            const randomIndex = Math.floor(Math.random() * availableTiles.length);
            const { x, y } = availableTiles.splice(randomIndex, 1)[0]; // Remove selected tile

            console.log(`Placing Snow Tree at map ${mapNum}, x: ${x}, y: ${y}`);
            const snowTree = new OBJ_SnowTree();
            snowTree.x = x * this.gp.tileSize;
            snowTree.y = y * this.gp.tileSize;
            this.gp.obj[mapNum].push(snowTree);
        }
    }
    processTrees(setup, mapNum, mapIndex) {
        setup.trees?.forEach(tree => {
            if (tree.range) {
                for (let x = tree.range.startX; x <= tree.range.endX; x++) {
                    for (let y = tree.range.startY; y <= tree.range.endY; y++) {
                        const tileNum = this.gp.tileM.mapTileNum[mapNum]?.[x]?.[y];
                        if (tileNum === TILE_TYPES.GRASS || tileNum === TILE_TYPES.SNOW) {
                            console.log(`Placing tree at map ${mapNum}, x: ${x}, y: ${y}`);
                            this.gp.obj[mapNum][mapIndex] = new OBJ_Tree();
                            this.gp.obj[mapNum][mapIndex].x = x * this.gp.tileSize;
                            this.gp.obj[mapNum][mapIndex].y = y * this.gp.tileSize;
                            mapIndex++;
                        } else {
                            console.log(`Skipping tree at (${x}, ${y}) due to tile type: ${tileNum}`);
                        }
                    }
                }
            } else if (tree.randomRange) {
                const { startX, endX, startY, endY, count } = tree.randomRange;
                this.addRandomTreesInRange(mapNum, startX, endX, startY, endY, count);
            } else if (tree.snowRange) {
                for (let x = tree.snowRange.startX; x <= tree.snowRange.endX; x++) {
                    for (let y = tree.snowRange.startY; y <= tree.snowRange.endY; y++) {
                        const tileNum = this.gp.tileM.mapTileNum[mapNum]?.[x]?.[y];
                        if (tileNum === TILE_TYPES.GRASS || tileNum === TILE_TYPES.SNOW) {
                            console.log(`Placing Snow Tree at map ${mapNum}, x: ${x}, y: ${y}`);
                            this.gp.obj[mapNum][mapIndex] = new OBJ_SnowTree();
                            this.gp.obj[mapNum][mapIndex].x = x * this.gp.tileSize;
                            this.gp.obj[mapNum][mapIndex].y = y * this.gp.tileSize;
                            mapIndex++;
                        } else {
                            console.log(`Skipping Snow Tree at (${x}, ${y}) due to tile type: ${tileNum}`);
                        }
                    }
                }
            } else if (tree.snowRandomRange) {
                const { startX, endX, startY, endY, count } = tree.snowRandomRange;
                this.addRandomSnowTreesInRange(mapNum, startX, endX, startY, endY, count);
            } else {
                console.log(`Placing individual tree at map ${mapNum}, x: ${tree.x}, y: ${tree.y}`);
                this.gp.obj[mapNum][mapIndex] = new OBJ_Tree();
                this.gp.obj[mapNum][mapIndex].x = tree.x * this.gp.tileSize;
                this.gp.obj[mapNum][mapIndex].y = tree.y * this.gp.tileSize;
                mapIndex++;
            }
        });
        return mapIndex;
    }
    

    setObject() {
        
        Object.keys(this.mapSetups).forEach(mapNum => {
            if (!this.gp.obj[mapNum]) {
                this.gp.obj[mapNum] = [];
            }
        });

       
        Object.keys(mapConnections).forEach(mapNum => {
            let mapIndex = 0; 
            
            mapConnections[mapNum].doors?.forEach(doorConfig => {
                this.gp.obj[mapNum][mapIndex] = new OBJ_Door();
                this.gp.obj[mapNum][mapIndex].x = doorConfig.x * this.gp.tileSize;
                this.gp.obj[mapNum][mapIndex].y = doorConfig.y * this.gp.tileSize;
                this.gp.obj[mapNum][mapIndex].destinationMap = doorConfig.destinationMap;
                this.gp.obj[mapNum][mapIndex].destinationX = doorConfig.destinationX;
                this.gp.obj[mapNum][mapIndex].destinationY = doorConfig.destinationY;
                mapIndex++;
            });

            // Set uArrows
            mapConnections[mapNum].uArrow?.forEach(doorConfig => {
                this.gp.obj[mapNum][mapIndex] = new UP_Arrow();
                this.gp.obj[mapNum][mapIndex].x = doorConfig.x * this.gp.tileSize;
                this.gp.obj[mapNum][mapIndex].y = doorConfig.y * this.gp.tileSize;
                this.gp.obj[mapNum][mapIndex].destinationMap = doorConfig.destinationMap;
                this.gp.obj[mapNum][mapIndex].destinationX = doorConfig.destinationX;
                this.gp.obj[mapNum][mapIndex].destinationY = doorConfig.destinationY;
                mapIndex++;
            });
    
            // Set dArrows - continue from the current mapIndex
            mapConnections[mapNum].dArrow?.forEach(doorConfig => {
                this.gp.obj[mapNum][mapIndex] = new DOWN_Arrow();
                this.gp.obj[mapNum][mapIndex].x = doorConfig.x * this.gp.tileSize;
                this.gp.obj[mapNum][mapIndex].y = doorConfig.y * this.gp.tileSize;
                this.gp.obj[mapNum][mapIndex].destinationMap = doorConfig.destinationMap;
                this.gp.obj[mapNum][mapIndex].destinationX = doorConfig.destinationX;
                this.gp.obj[mapNum][mapIndex].destinationY = doorConfig.destinationY;
                mapIndex++;
            });
        }); 

        
        Object.keys(this.mapSetups).forEach(mapNum => {
            let mapIndex = this.gp.obj[mapNum]?.length || 0;  // Start after doors /////////////////////// IMPORTANT TO SET ITEMS UP HERE TOOO!!!!!
            const setup = this.mapSetups[mapNum];

            // Process trees
            mapIndex = this.processTrees(setup, mapNum, mapIndex);
            
            setup.objects?.forEach(obj => {
                switch(obj.type) {
                    case "key":
                        this.gp.obj[mapNum][mapIndex] = new OBJ_Key();
                        break;
                    case "chest":
                        this.gp.obj[mapNum][mapIndex] = new OBJ_Chest();
                        break;
                    case "hotdog":
                        this.gp.obj[mapNum][mapIndex] = new OBJ_Hotdog();
                        break;
                    case "woodenStaff":                      // Add this case
                        this.gp.obj[mapNum][mapIndex] = new OBJ_WoodenStaff();
                        break;
                    case "leatherRobe":                      // Add this case
                        this.gp.obj[mapNum][mapIndex] = new OBJ_LeatherRobe();
                        break;
                    case "robeOfElders":
                        this.gp.obj[mapNum][mapIndex] = new OBJ_RobeOfElders();
                        break;
                    case "staffOfTrees":
                        this.gp.obj[mapNum][mapIndex] = new OBJ_StaffOfTrees();
                        break;
                    case "Tree":
                        this.gp.obj[mapNum][mapIndex] = new OBJ_Tree();
                        if (obj.size) {
                            this.gp.obj[mapNum][mapIndex].width *= obj.size;
                            this.gp.obj[mapNum][mapIndex].height *= obj.size;
                        }
                        break;
                    case "Red Door":
                        this.gp.obj[mapNum][mapIndex] = new OBJ_RedDoor();
                        if (obj.requiredKey) this.gp.obj[mapNum][mapIndex].requiredKey = obj.requiredKey;
                        break;
                    case "Blue Door":
                        this.gp.obj[mapNum][mapIndex] = new OBJ_BlueDoor();
                        if (obj.requiredKey) this.gp.obj[mapNum][mapIndex].requiredKey = obj.requiredKey;
                        break;
                    case "Green Door":
                        this.gp.obj[mapNum][mapIndex] = new OBJ_GreenDoor();
                        if (obj.requiredKey) this.gp.obj[mapNum][mapIndex].requiredKey = obj.requiredKey;
                        break;
                    case "Purple Door":
                        this.gp.obj[mapNum][mapIndex] = new OBJ_PurpleDoor();
                        if (obj.requiredKey) this.gp.obj[mapNum][mapIndex].requiredKey = obj.requiredKey;
                        break;
                    case "Red Key":
                        this.gp.obj[mapNum][mapIndex] = new OBJ_RedKey();
                        if (obj.color) this.gp.obj[mapNum][mapIndex].color = obj.color;
                        break;
                    case "Blue Key":
                        this.gp.obj[mapNum][mapIndex] = new OBJ_BlueKey();
                        if (obj.color) this.gp.obj[mapNum][mapIndex].color = obj.color;
                        break;
                    case "Green Key":
                        this.gp.obj[mapNum][mapIndex] = new OBJ_GreenKey();
                        if (obj.color) this.gp.obj[mapNum][mapIndex].color = obj.color;
                        break;
                    case "Purple Key":
                        this.gp.obj[mapNum][mapIndex] = new OBJ_PurpleKey();
                        if (obj.color) this.gp.obj[mapNum][mapIndex].color = obj.color;
                        break;
                }
                if (this.gp.obj[mapNum][mapIndex]) {
                    this.gp.obj[mapNum][mapIndex].x = obj.x * this.gp.tileSize;
                    this.gp.obj[mapNum][mapIndex].y = obj.y * this.gp.tileSize;
                    mapIndex++;
                }
            });
        });
    }

    setNPC() {
        Object.keys(this.mapSetups).forEach(mapNum => {
            let mapIndex = 0;
            const setup = this.mapSetups[mapNum];
            
            setup.npcs?.forEach(npc => {
                if (npc.type === "oldman") {
                    this.gp.npc[mapNum] = this.gp.npc[mapNum] || [];
                    this.gp.npc[mapNum][mapIndex] = new NPC_OldMan(this.gp);
                    this.gp.npc[mapNum][mapIndex].x = npc.x * this.gp.tileSize;
                    this.gp.npc[mapNum][mapIndex].y = npc.y * this.gp.tileSize;
                    mapIndex++;
                }
            });
        })
    }

    setMonster() {
        Object.keys(this.mapSetups).forEach(mapNum => {
            let mapIndex = 0;
            const setup = this.mapSetups[mapNum];
    
            setup.monsters?.forEach(monster => {
                if (monster.type === "slime") {
                    this.gp.monster[mapNum][mapIndex] = new MON_GreenSlime(this.gp);
                } else if (monster.type === "shootingSlime") {
                    this.gp.monster[mapNum][mapIndex] = new MON_ShootingSlime(this.gp);
                } else if (monster.type === "Final Boss") {
                    this.gp.monster[mapNum][mapIndex] = new MON_FinalBoss(this.gp);
                }
    
                if (this.gp.monster[mapNum][mapIndex]) {
                    this.gp.monster[mapNum][mapIndex].x = monster.x * this.gp.tileSize;
                    this.gp.monster[mapNum][mapIndex].y = monster.y * this.gp.tileSize;
                    mapIndex++;
                }
            });
        });
    }
}