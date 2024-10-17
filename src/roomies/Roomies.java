package roomies;

import java.util.Scanner;


public class Roomies {


    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);
        String resp;
        Roomies dept = new Roomies(); 

        do {
            System.out.println("1. ADD ROOMS");
            System.out.println("2. VIEW ROOMS");
            System.out.println("3. UPDATE ROOMS");
            System.out.println("4. DELETE ROOMS");
            System.out.println("5. EXIT");

            System.out.print("Enter Action: ");
            int action = sc.nextInt();
            switch (action) {
                case 1:
                    dept.addRoomy();
                    break;
                case 2:
                    dept.viewRoomy();
                    break;
                case 3:
                    dept.viewRoomy();
                    dept.updateRoomy(); 
                    break;
                case 4:
                    dept.viewRoomy();
                    dept.deleteRoomy(); 
                    dept.viewRoomy();
                    break;
                case 5:
                    System.out.println("Thank You!");
                    return; 
                default:
                    System.out.println("Invalid action. Please try again.");
            }

            System.out.print("Continue? ");
            resp = sc.next();

        } while (resp.equalsIgnoreCase("yes"));

        System.out.println("Thank You!");
        sc.close(); 
    }

    public void addRoomy() {
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        
        System.out.print("Room Number: ");
        sc.nextLine();
        String rnum = sc.nextLine();
        System.out.print("Room Type: ");
        String rtype = sc.nextLine();
        System.out.print("Availability Status: ");
        String ravss = sc.nextLine();
        System.out.print("Daily Rate: ");
        String rrate = sc.nextLine();
        
        String sql = "INSERT INTO tbl_rooms (room_number, room_type, availability_status, daily_rate) VALUES (?, ?, ?, ?)";
        conf.addRecord(sql, rnum, rtype, ravss, rrate);
    }

    private void viewRoomy() {
        String qry = "SELECT * FROM tbl_rooms";
        String[] hdrs = {"Room ID", "Room Number", "Room Type", "Availability Status", "Daily Rate"};
        String[] clms = {"room_id", "room_number", "room_type", "availability_status", "daily_rate"};

        config conf = new config();
        conf.viewRecords(qry, hdrs, clms);
    }

    private void updateRoomy() { 
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the ID to Update: ");
        int id = sc.nextInt();
        System.out.print("Enter New Room Number: ");       
        String rnum = sc.next();
        System.out.print("Enter New Room Type: ");
        String rtype = sc.next();
        System.out.print("Enter New Status: ");
        String ravss = sc.next();
        System.out.print("Enter Rate: ");
        String rrate = sc.next();
       
        
        
        String qry = "UPDATE tbl_rooms SET room_number = ?, room_type = ?, availability_status = ?, daily_rate = ? WHERE e_id = ?";

        config conf = new config();
        conf.updateRecord(qry, rnum, rtype, ravss, rrate);
    }

    private void deleteRoomy() { 
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the ID to Delete: ");
        int id = sc.nextInt();

        String qry = "DELETE FROM tbl_rooms WHERE room_id = ?";
        config conf = new config();
        conf.deleteRecord(qry, id);
        }
    }
