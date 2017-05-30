
import java.util.*;
public class Game {
    public static void main(String[]args){
        //variables that will be called later
        Scanner in = new Scanner(System.in);
        //variables that will be translated to lower case
        String actOne = "";
        String act = "";
        String direcOne = "";
        String direc = "";
        String obtainOne = "";
        String obtain = "";
        String deployOne = "";
        String deploy = "";
        String readOne = "";
        String read = "";
        String openOne = "";
        String open = "";
        String withOne = "";
        String with = "";
        String targetOne = "";
        String target = "";
        String a = "";
        String b = "";
        int loop = 1;
        int x = 8;
        int y = 5;
        int flash = 1;
        int dark = 1;
        int lockers = 1;
        int keyOne = 0;
        int key = 1;
        int crowbar = 1;
        int drink = 0;
        int aid = 0;

        //Map location description and parameters
        String[][] loc = new String[10][11];
        loc[1][2] = "wall";
        loc[0][3] = "wall";
        loc[0][8] = "wall";
        loc[1][4] = "wall";
        loc[1][6] = "wall";
        loc[1][7] = "wall";
        loc[1][9] = "wall";
        loc[2][3] = "wall";
        loc[2][5] = "wall";
        loc[2][7] = "wall";
        loc[2][10] = "wall";
        loc[3][1] = "wall";
        loc[3][2] = "wall";
        loc[3][9] = "wall";
        loc[4][1] = "wall";
        loc[4][3] = "wall";
        loc[4][4] = "wall";
        loc[4][6] = "wall";
        loc[4][7] = "wall";
        loc[4][10] = "wall";
        loc[5][1] = "wall";
        loc[5][10] = "wall";
        loc[6][1] = "wall";
        loc[6][3] = "wall";
        loc[6][4] = "wall";
        loc[6][6] = "wall";
        loc[6][7] = "wall";
        loc[6][9] = "wall";
        loc[7][1] = "wall";
        loc[7][3] = "wall";
        loc[7][4] = "wall";
        loc[7][6] = "wall";
        loc[7][10] = "wall";
        loc[8][1] = "wall";
        loc[8][2] = "wall";
        loc[8][4] = "wall";
        loc[8][6] = "wall";
        loc[8][7] = "wall";
        loc[8][8] = "wall";
        loc[8][9] = "wall";
        loc[9][5] = "wall";
        loc[8][5] = "-Entrance Hall-" + "\n" + "You are infront of a boarded up and locked door. There is a corridor leading north.";
        loc[7][5] = "-A HALL-" + "\n" + "You are in the middle of |A HALL|. The hall can be seen to continue further north, and the entrance is south.";
        loc[6][5] = "-A HALL-" + "\n" + "You are further along |A HALL|. A corridor goes south, and a particullary large room is north.";
        loc[5][5] = "-Lobby-" + "\n" + "You are now within a lobby of some sort. You see corridors in each direction.";
        loc[4][5] = "-C HALL-" + "\n" + "You see nothing within this hall. You see an interesecting hallway further north, and the lobby is south.";
        loc[3][5] = "-C1 HALL-" + "\n" + "You are in the middle of an intersection. Corridors lead west and east, and C1 HALL is south of you.";
        loc[3][4] = "-C1 HALL-" + "\n" + "You are further west of |C1 HALL|. You see a dark room north of you, a corridor leading east, and another room leading further west.";
        loc[2][4] = "-Library-" + "\n" + "You are within the library. You see a corridor south of you, and a ladder leading up into a dark mysterious hole.";
        loc[1][3] = "-Dark attic-" + "\n" + "You are above the library, and is now within a dark mysterious attic. The ladder leads down to the library.";
        loc[3][6] = "-C1 HALL-" + "\n" + "You are further east of |C1 HALL|. You see a door north of you, a corridor leading west, and another room leading further east";

        //Adding potential items within the location square, or adding more flavor text
        String[][] item = new String[10][11];
        item[8][5] = "You see a flashlight lying on the floor.";
        item[7][5] = "The halls are lined with locked lockers and pictures.";
        item[6][5] = "You see a drinking fountain at the end of the hallway.";
        item[5][5] = "You see a crowbar lying on the floor in the middle of the lobby.";
        item[4][5] = "You only see dust surrounding the floor.";
        item[3][5] = "You see nothing around you but moss, and blacken tiles on the wall";
        item[3][4] = "The carpet beneath your feet is covered in Kool Aid.";
        item[2][4] = "You only see books scattered around the library. The books cannot be picked up, because you are disgusted with literature.";
        a = "You see nothing but empty boxes, but you do see this sticky clear substance that is covering the walls.";
        b = "The room is covered in darkness, but the sticky clear substance covering the wall glowed in the dark, spelling the word 'KEK'.";
        item[1][3] = "";
        item[3][6] = "You see a sign next to the door |Principal's Office|. Nothing but a weird odor covers this part of the hallway.";

        List<String> move = Arrays.asList("move", "walk", "go", "head", "run", "travel", "swagger");
        List<String> dir = Arrays.asList("north", "n", "south", "s", "east", "e", "west", "w");
        List<String> take = Arrays.asList("take", "pickup", "grab", "acquire", "obtain");
        List<String> body = Arrays.asList("hands", "hand", "feet", "foot");
        List<String> use = Arrays.asList("use", "deploy", "hold");
        List<String> locker = Arrays.asList("lockers", "locker");
        List<String> alt = Arrays.asList("up", "down");
        List<String> invent = new ArrayList<String>();

        //a loop that will always ask the user for input, and will function according to their input
        while (loop == 1){
            System.out.println(loc[x][y] + "\n" + item[x][y] + "\n");
            System.out.print("Action/Direction: ");
            actOne = in.nextLine();
            act = actOne.toLowerCase();
            System.out.println("");
//-----------------------------------------------------------------------------------------------
            //movement checks
            if (dir.contains(act) == true){
                if (act.contains("north") == true || act.contains("n") == true){
                    if (loc[x-1][y] != "wall" && x != 3 && y != 4){
                        System.out.println("|Moved north|");
                        x--;
                    }
                    else if(x == 3 && y == 4 && dark == 1){
                        System.out.println("*You are too afraid of the dark*");
                    }
                    else if(x == 3 && y == 4 && dark == 0){
                        System.out.println("|Moved north|");
                        x--;
                    }
                    else{
                        System.out.println("-50 brain cells |Ran into a wall|");
                    }
                }
                else if (act.contains("south") == true || act.contains("s") == true){
                    if (loc[x+1][y] != "wall"){
                        System.out.println("|Moved south|");
                        x++;
                    }
                    else{
                        System.out.println("-50 brain cells |Ran into a wall|");
                    }
                }
                else if (act.contains("east") == true || act.contains("e") == true){
                    if (loc[x][y+1] != "wall"){
                        System.out.println("|Moved east|");
                        y++;
                    }
                    else{
                        System.out.println("-50 brain cells |Ran into a wall|");
                    }
                }
                else if(act.contains("west") == true || act.contains("w") == true){
                    if (loc[x][y-1] != "wall"){
                        System.out.println("|Moved west|");
                        y--;
                    }
                    else{
                        System.out.println("-50 brain cells |Ran into a wall|");
                    }
                }
                else{
                    System.out.println("|Not a direction|");
                }
            }
//-----------------------------------------------------------------------------------------------
            //checks if the input had movement verbs
            else if (move.contains(act) == true){
                System.out.print("Direction: ");
                direcOne = in.nextLine();
                direc = direcOne.toLowerCase();
                System.out.println("");
                if (direc.contains("north") == true || direc.contains("n") == true){
                    if (loc[x-1][y] != "wall" && x != 3 && y != 4){
                        if (act.contains("swagger") == true){
                            System.out.println("+50 style points |Moved north|");
                            x--;
                        }
                        else{
                            System.out.println("|Moved north|");
                            x--;
                        }
                    }
                    else if(x == 3 && y == 4 && dark == 1){
                        System.out.println("*You are too afraid of the dark*");
                    }
                    else if(x == 3 && y == 4 && dark == 0){
                        System.out.println("|Moved north|");
                        x--;
                    }
                    else{
                        System.out.println("-50 brain cells |Ran into a wall|");
                    }
                }
                else if (direc.contains("south") == true || direc.contains("s") == true){
                    if (loc[x+1][y] != "wall"){
                        if (act.contains("swagger") == true){
                            System.out.println("+50 style points |Moved south|");
                            x++;
                        }
                        else{
                            System.out.println("|Moved south|");
                            x++;
                        }
                    }
                    else{
                        System.out.println("-50 brain cells |Ran into a wall|");
                    }
                }
                else if (direc.contains("east") == true || direc.contains("e") == true){
                    if (loc[x][y+1] != "wall"){
                        if (act.contains("swagger") == true){
                            System.out.println("+50 style points |Moved east|");
                            y++;
                        }
                        else{
                            System.out.println("|Moved east|");
                            y++;
                        }
                    }
                    else{
                        System.out.println("-50 brain cells |Ran into a wall|");
                    }
                }
                else if (direc.contains("west") == true || direc.contains("w") == true){
                    if (loc[x][y-1] != "wall"){
                        if (act.contains("swagger") == true){
                            System.out.println("+50 style points |Moved west|");
                            y--;
                        }
                        else{
                            System.out.println("|Moved west|");
                            y--;
                        }
                    }
                    else{
                        System.out.println("-50 brain cells |Ran into a wall|");
                    }
                }
                else if (direc.contains("up") == true && x == 2 && y == 4){
                    x = 1;
                    y = 3;
                    System.out.println("|You have moved up|");
                }
                else if(direc.contains("down") == true && x == 1 && y == 3){
                    x = 2;
                    y = 4;
                    System.out.println("|You have moved down|");
                }
                else{
                    System.out.println("*Not a direction*");
                }
            }
//-----------------------------------------------------------------------------------------------
            //allowing user to add items into inventory
            else if (take.contains(act) == true){
                System.out.print("Take: ");
                obtainOne = in.nextLine();
                obtain = obtainOne.toLowerCase();
                System.out.println("");
                if (obtain.contains("flashlight") == true && x == 8 && flash == 1){
                    System.out.println("|Acquired a flashlight|");
                    invent.add(obtain);
                    item[8][5] = "";
                    flash = 0;
                }
                else if (obtain.contains("key") == true && x == 7 && y == 5 && keyOne == 1 && key == 1){
                    System.out.println("|Acquired a key|");
                    invent.add(obtain);
                    item[7][5] = "All the lockers are now opened, thanks to someone.";
                    key = 0;
                }
                else if (obtain.contains("crowbar") == true && x == 5 && y == 5 && crowbar == 1){
                    System.out.println("|Acquired a crowbar|");
                    invent.add(obtain);
                    item[5][5] = "";
                    crowbar = 0;
                }
                else{
                    System.out.println("*Not an item*");
                }
            }
//-----------------------------------------------------------------------------------------------
            //used to allow users to let them use their items within their inventory
            else if (use.contains(act) == true){
                System.out.println("Use: ");
                deployOne = in.nextLine();
                deploy = deployOne.toLowerCase();
                System.out.println("");
                if (invent.contains(deploy) == true){
                    if (deploy.contains("flashlight") == true && dark == 1){
                        System.out.println("The shadows will fear you |Flashlight on|");
                        dark = 0;
                        item[1][3] = a;
                    }
                    else if (deploy.contains("flashlight") == true && dark == 0){
                        System.out.println("You will fear the shadows |Flashlight off|");
                        dark = 1;
                        item[1][3] = b;
                        if (x == 2 && y == 4 && dark == 1){
                            System.out.println("You ran out of the room out of the fear of the darkness." + "\n" + "|Moved south|");
                            x++;
                        }
                    }
                    else if (deploy.contains("crowbar") == true){
                        System.out.println("On: ");
                        targetOne = in.nextLine();
                        target = targetOne.toLowerCase();
                        System.out.println("");
                        if (locker.contains(target) == true && x == 7 && y ==5 && lockers == 1){
                            System.out.println("|You pried open all the lockers|");
                            item[7][5] = "All the lockers are now opened, thanks to someone. There is also a key left in one of the lockers.";
                            lockers = 0;
                            keyOne = 1;
                        }
                        else if(lockers == 0){
                            System.out.println("*The lockers are already opened*");
                        }
                        else{
                            System.out.println("*That is not the time nor place to use that here!*");
                        }
                    }
                }
                else if(deploy.contains("ladder") == true && x == 2 && y == 4){
                    System.out.println("|You have moved up|");
                    x = 1;
                    y = 3;
                }
                else if (deploy.contains("ladder") == true && x == 1 && y == 3){
                    System.out.println("|You have moved down|");
                    x = 2;
                    y = 4;
                }
                else{
                    System.out.println("*Cannot use*");
                }
            }
//-----------------------------------------------------------------------------------------------
            //checks their inventory for items, and prints it out
            else if (act.contains("check") == true || act.contains("inventory") == true){
                System.out.println("Inventory: " + invent);
            }
//-----------------------------------------------------------------------------------------------
            //allows the players to read a desc. of an item and to obtain potential hints
            else if (act.contains("read") == true){
                System.out.print("Item: ");
                readOne = in.nextLine();
                read = readOne.toLowerCase();
                System.out.println("");
                if (invent.contains(read) == true){
                    if (read.contains("flashlight") == true){
                        System.out.println("*perhaps this can provide light*");
                    }
                    else if (read.contains("crowbar") == true){
                        System.out.println("*perhaps this can open something that's locked*");
                    }
                }
                else{
                    System.out.println("*Cannot read item that's not within inventory*");
                }
            }
//-----------------------------------------------------------------------------------------------
            //alternative way to open objects other than the USE method
            else if (act.contains("open") == true){
                System.out.println("Target: ");
                openOne = in.nextLine();
                open = openOne.toLowerCase();
                System.out.println("");
                System.out.println("With: ");
                withOne = in.nextLine();
                with = withOne.toLowerCase();
                System.out.println("");
                if (locker.contains(open) == true && x == 7 && y == 5){
                    if (with.contains("crowbar") == true && invent.contains("crowbar") == true && lockers == 1){
                        System.out.println("|You pried open all the lockers|");
                        item[7][5] = "All the lockers are now opened, thanks to someone. There is also a key left in one of the lockers.";
                        lockers = 0;
                        keyOne = 1;
                    }
                    else if (body.contains(with) == true && x == 7 && y == 5 && lockers == 1){
                        System.out.println("*You the lack strength to open the lockers*");
                    }
                    else{
                        System.out.println("*You cannot open the lockers with that*");
                    }
                }
                else{
                    System.out.println("*There is no lockers here*");
                }
            }
//-----------------------------------------------------------------------------------------------
            //a drinking easter egg
            else if (act.contains("drink") == true && x == 6 && y == 5){
                drink++;
                switch (drink){
                    case 1:
                        System.out.println("Thank you, I was getting quite thirsty from narrating.");
                        break;
                    case 2:
                        System.out.println("Mhmmm, that's some good water.");
                        break;
                    case 3:
                        System.out.println("I think I'm good, my thirst is quite quenched.");
                        break;
                    case 4:
                        System.out.println("Please stop, I'm going to pop if I drink anymore...");
                        break;
                    case 5:
                        System.out.println("AGHHHHH HELP ME, MAKE THIS MANIAC STOP!!!");
                        break;
                    default:
                        System.out.println("Hello. I'm your new narrator, Dan. I cannot drink water, therefore you cannot kill me off.");
                        break;
                }
            }
//-----------------------------------------------------------------------------------------------
            //up and down commands on the ladder within the library
            else if(alt.contains(act) == true){
                if (act.contains("up") == true && x == 2 && y == 4){
                    x = 1;
                    y = 3;
                    System.out.println("|You have moved up|");
                }
                else if(act.contains("down") == true && x == 1 && y == 3){
                    x = 2;
                    y = 4;
                    System.out.println("|You have moved down|");
                }
                else{
                    System.out.println("*Cannot move up nor down*");
                }
            }
//-----------------------------------------------------------------------------------------------
            else if(act.contains("oh no") == true){
                aid++;
                if (aid % 3 == 0){
                    System.out.println("A GIANT KOOL AID MAN BURST INTO THE AREA YELLING 'OH YEAH!!!' and quickly dissappeared after handing you something." + "\n" + "*The Kool Aid man gave you a Kool Aid drink*");
                    invent.add("kool aid");
                }
                else{
                    System.out.println("Perhaps if you keep chanting these words, something will happen.");
                }
            }
//-----------------------------------------------------------------------------------------------
            //in case the input does not match a listed action
            else{
                System.out.println("*Not an action*");
            }
            System.out.println("\n" + "-----------------------------------------------------------------");
        }
    }
}

