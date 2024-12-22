package hust.soict.dsai.aims;

import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import java.util.*;

public class Aims {
    public static void main(String[] args) {
        // Khởi tạo các đối tượng mẫu cho cửa hàng
        DigitalVideoDisc dvd = new DigitalVideoDisc("Tay Du Ky", "Fantasy", "Ngo Thua An", 112, 18.55f);

        ArrayList<Track> tracks = new ArrayList<Track>();
        tracks.add(new Track("Nhac Trinh (Tran Phuong Tuan)", 3));
        tracks.add(new Track("Tuyen tap Dam Vinh Hung", 4));
        CompactDisc cd = new CompactDisc("Tom & Jerry", "Cartoon", "Various artist", tracks, 25.5f);

        ArrayList<String> authors = new ArrayList<String>();
        authors.add("Rowling");
        authors.add("Cuong Pham");
        Book book = new Book("Harry Potter", "Novel", 25.2f, authors);

        Store store = new Store();
        store.addMedia(cd);
        store.addMedia(dvd);
        store.addMedia(book);

        Scanner sc = new Scanner(System.in);
        Cart cart = new Cart();

        // Hiển thị menu chính
        showMenu(sc, store, cart);
    }

    /**
     * Hiển thị menu chính của ứng dụng AIMS.
     * @param scanner Scanner dùng để nhập dữ liệu từ người dùng.
     * @param store Cửa hàng chứa các media.
     * @param cart Giỏ hàng của người dùng.
     */
    public static void showMenu(Scanner scanner, Store store, Cart cart) {
        while (true) {
            System.out.println(
                    """                
                            CuongPQ - 5604
                            AIMS:
                            --------------------------------
                            1. View store
                            2. Update store
                            3. See current cart
                            0. Exit
                            --------------------------------
                            Please choose a number: 0-1-2-3
                                     """);
            int option = getOption(scanner);
            switch (option) {
                case 0 -> {
                    System.out.println("CuongPQ - 5604: Exiting program...");
                    scanner.close();
                    System.exit(0);
                }
                case 1 -> storeMenu(scanner, store, cart);
                case 2 -> updateStoreMenu(scanner, store);
                case 3 -> {
                    cart.printCart();
                    cartMenu(scanner, cart);
                }
            }
        }
    }

    /**
     * Hiển thị menu quản lý cửa hàng.
     * @param scanner Scanner dùng để nhập dữ liệu từ người dùng.
     * @param store Cửa hàng chứa các media.
     */
    public static void updateStoreMenu(Scanner scanner, Store store) {
        System.out.println("CuongPQ - 5604: Update Store Menu:");
        System.out.println("""
                ==========================
                1. Add Media
                2. Delete Media
                3. Update Media in Store
                0. Back
                ==========================
                Option:
                """);
        int option = inputInt(scanner);
        switch (option) {
            case 1 -> {
                System.out.println("""
                        CuongPQ - 5604: Add Media Menu:
                        1. DigitalVideoDisc
                        2. CompactDisc
                        3. Book
                        -------
                        -> Your type:""");
                int option2 = getOption(scanner);
                scanner.nextLine();
                System.out.print("CuongPQ - 5604: Enter title: ");
                String title = scanner.nextLine();
                System.out.print("CuongPQ - 5604: Enter category: ");
                String category = scanner.nextLine();
                System.out.print("CuongPQ - 5604: Enter cost: ");
                float cost = inputFloat(scanner);
                scanner.nextLine();
                switch (option2) {
                    case 1 -> {
                        System.out.print("CuongPQ - 5604: Enter director's name: ");
                        String director = scanner.nextLine();
                        System.out.print("CuongPQ - 5604: Enter dvd's length: ");
                        int length = inputInt(scanner);
                        scanner.nextLine();
                        store.addMedia(new DigitalVideoDisc(title, category, director, length, cost));
                    }
                    case 3 -> {
                        System.out.print("CuongPQ - 5604: Enter author's name (Enter nothing to skip): ");
                        String authorInput = scanner.nextLine();
                        ArrayList<String> authors = new ArrayList<String>();

                        while (!authorInput.isEmpty()) {
                            authors.add(authorInput);
                            System.out.print("CuongPQ - 5604: Enter author's name (Enter nothing to skip): ");
                            authorInput = scanner.nextLine();
                        }

                        store.addMedia(new Book(title, category, cost, authors));
                    }
                    case 2 -> {
                        System.out.print("CuongPQ - 5604: Enter artist's name: ");
                        String artist = scanner.nextLine();
                        System.out.print("CuongPQ - 5604: Enter number of track: ");
                        int nbTrack = inputInt(scanner);
                        scanner.nextLine();
                        ArrayList<Track> tracks = new ArrayList<>();
                        for (int i = 0; i < nbTrack; i++) {
                            System.out.print("CuongPQ - 5604: Enter Track[" + i + "]'s name: ");
                            String trackName = scanner.nextLine();
                            System.out.print("CuongPQ - 5604: Enter Track[" + i + "]'s length: ");
                            int trackLength = inputInt(scanner);
                            tracks.add(new Track(trackName, trackLength));
                            scanner.nextLine();
                        }
                        store.addMedia(new CompactDisc(title, category, artist, tracks, cost));
                    }
                }
            }
            case 2 -> {
                System.out.print("CuongPQ - 5604: Enter item's title: ");
                scanner.nextLine();
                String title = scanner.nextLine();
                Iterator<Media> iter = store.getItemsInStore().iterator();
                while (iter.hasNext()) {
                    Media item = iter.next();
                    if (item.getTitle().equals(title)) {
                        iter.remove();
                        System.out.println("CuongPQ - 5604: " + item.getClass().getSimpleName() + " " + item.getTitle() + " has been deleted from the store!");
                    }
                }
            }
            case 3 -> {
                System.out.print("CuongPQ - 5604: Enter item's id: ");
                int id = inputInt(scanner);
                scanner.nextLine();

                Media media = store.getItemsInStore().get(id);
                if (media == null) {
                    System.out.println("CuongPQ - 5604: Media with id " + id + " not found!");
                    return;
                }

                System.out.println("CuongPQ - 5604: Now you are updating: " + media);

                System.out.print("CuongPQ - 5604: Enter title: ");
                String title = scanner.nextLine();
                System.out.print("CuongPQ - 5604: Enter category: ");
                String category = scanner.nextLine();
                System.out.print("CuongPQ - 5604: Enter cost: ");
                float cost = inputFloat(scanner);
                media.setTitle(title);
                media.setCategory(category);
                media.setCost(cost);

                if (media instanceof DigitalVideoDisc digitalVideoDisc) {
                    System.out.print("CuongPQ - 5604: Enter new director's name: ");
                    String director = scanner.nextLine();
                    System.out.print("CuongPQ - 5604: Enter new dvd's length: ");
                    int length = inputInt(scanner);
                    digitalVideoDisc.setDirector(director);
                    digitalVideoDisc.setLength(length);
                } else if (media instanceof Book book) {
                    System.out.print("CuongPQ - 5604: Enter new author's name (Enter nothing to skip): ");
                    String authorInput = scanner.nextLine();

                    while (!authorInput.isEmpty()) {
                        book.addAuthor(authorInput);
                        System.out.print("CuongPQ - 5604: Enter new author's name (Enter nothing to skip): ");
                        authorInput = scanner.nextLine();
                    }
                } else if (media instanceof CompactDisc compactDisc) {
                    System.out.print("CuongPQ - 5604: Enter new artist's name: ");
                    String artist = scanner.nextLine();
                    System.out.print("CuongPQ - 5604: Enter new number of tracks: ");
                    int nbTrack = inputInt(scanner);
                    scanner.nextLine();
                    ArrayList<Track> tracks = new ArrayList<>();
                    for (int i = 0; i < nbTrack; i++) {
                        System.out.print("CuongPQ - 5604: Enter Track[" + i + "]'s name: ");
                        String trackName = scanner.nextLine();
                        System.out.print("CuongPQ - 5604: Enter Track[" + i + "]'s length: ");
                        int trackLength = inputInt(scanner);
                        tracks.add(new Track(trackName, trackLength));
                        scanner.nextLine();
                    }
                    compactDisc.setArtist(artist);
                    compactDisc.setTracks(tracks);
                }
                System.out.println("Media have been updated !");
            }
            case 0 -> {
            }
        }
    }

    public static void mediaDetailsMenu(Scanner scanner, Store store, Cart cart) {
        System.out.print("CuongPQ - 5604: Enter media's title: ");
        String title = scanner.nextLine();
        Media item = store.searchByTitle(title);
        if(item == null) {
            System.out.println("There is no such media !");
            return;
        }
        System.out.println(item);
        while (true) {
            System.out.println("""
                            CuongPQ - 5604: Options:
                            --------------------------------
                            1. Add to cart
                            2. Play
                            0. Back
                            --------------------------------
                            Please choose a number: 0-1-2""");
            int option = getOption(scanner);
            scanner.nextLine();
            switch (option) {
                case 1 -> cart.addMedia(item);
                case 2 -> {
                    if (item.getClass().getSimpleName().equals("Book")) {
                        System.out.println("This media is unplayable");
                    } else {
                        if (item instanceof DigitalVideoDisc dvd) {
                                try {
                                    dvd.play();
                                } catch (PlayerException e) {
                                    System.out.println("Error: " + e.getMessage());
                                }
                        }
                        if (item instanceof CompactDisc cd) {
                            if (((CompactDisc) item).getTracks().isEmpty()) {
                                System.out.println("This CD has no track, can't play !");
                            } else {
                                try {
                                    cd.play();
                                } catch (PlayerException e) {
                                    System.out.println("Error: " + e.getMessage());
                                }
                            }
                        }
                    }
                }
                case 0 -> {
                    return;
                }
            }
        }
    }

    public static void storeMenu(Scanner scanner, Store store, Cart cart) {
        //show all items in store
        store.printStore();

        while (true) {
            System.out.println("""
                                CuongPQ - 5604: Options:\s
                                --------------------------------
                                1. See a media’s details
                                2. Add a media to cart
                                3. Play a media
                                4. See current cart
                                0. Back
                                --------------------------------
                                Please choose a number: 0-1-2-3-4
                                """);
            int option = getOption(scanner);
            scanner.nextLine();
            switch (option) {
                case 1 -> mediaDetailsMenu(scanner, store, cart);
                case 0 -> {
                    return;
                }
                case 2 -> {
                    System.out.print("CuongPQ - 5604: Enter media's title: ");
                    String title = scanner.nextLine();
                    Media item = store.searchByTitle(title);
                    if (item == null) {
                        System.out.println("There is no such media !");
                    } else {
                        cart.addMedia(item);
                    }
                }
                case 3 -> {
                    System.out.print("CuongPQ - 5604: Enter media's title: ");
                    String title = scanner.nextLine();
                    Media item = store.searchByTitle(title);
                    if (item == null) {
                        System.out.println("There is no such media !");
                    } else {
                        if (item.getClass().getSimpleName().equals("Book")) {
                            System.out.println("This media is unplayable");
                        } else {
                            if (item instanceof DigitalVideoDisc dvd) {
                                try {
                                    dvd.play();
                                } catch (PlayerException e) {
                                    System.out.println("Error: " + e.getMessage());
                                }
                            }
                            if (item instanceof CompactDisc cd) {
                                if (((CompactDisc) item).getTracks().isEmpty()) {
                                    System.out.println("This CD has no track, can't play !");
                                } else {
                                    try {
                                        cd.play();
                                    } catch (PlayerException e) {
                                        System.out.println("Error: " + e.getMessage());
                                    }
                                }
                            }
                        }
                    }
                }
                case 4 -> {
                    cart.printCart();
                    cartMenu(scanner,cart);
                }
            }
        }
    }

    public static void cartMenu(Scanner scanner, Cart cart) {
        while (true) {
            System.out.println("""
                    CuongPQ - 5604: Options:
                    --------------------------------
                    1. Filter medias in cart
                    2. Sort medias in cart
                    3. Remove media from cart
                    4. Play a media
                    5. Place order
                    0. Back
                    -------------------------------- 
                    Please choose a number: 0-1-2-3-4-5""");
            int option = getOption(scanner);
            scanner.nextLine();
            switch (option) {
                case 0 -> {
                    return;
                }
                case 1 -> {
                    System.out.println("""
                            1. Filter by title
                            2. Filter by id
                            ------------------
                            Your option:
                            """);
                    int option2 = getOption(scanner);
                    scanner.nextLine();
                    Media item;
                    if (option2 == 1) {
                        System.out.print("CuongPQ - 5604: Enter title: ");
                        String title = scanner.nextLine();
                        item = cart.searchByTitle(title);
                    } else {
                        System.out.print("CuongPQ - 5604: Enter id: ");
                        int id = inputInt(scanner);
                        item = cart.searchById(id);
                    }
                    if (item == null) {
                        System.out.println("Can't found this item inside cart!");
                    } else {
                        System.out.println(item);
                    }
                }
                case 2 -> {
                    System.out.println("""
                            1. Sort by title cost
                            2. Sort by cost title
                            ----------------
                            your option:
                            """);
                    int option2 = getOption(scanner);
                    scanner.nextLine();
                    if (option2 == 1) {
                        cart.sortByTitleCost();
                        cart.printCart();
                    } else {
                        cart.sortByCostTitle();
                        cart.printCart();
                    }
                }
                case 3 -> {
                    System.out.print("CuongPQ - 5604: Enter media's title: ");
                    String title = scanner.nextLine();
                    Media item = cart.searchByTitle(title);
                    if (item == null) {
                        System.out.println("There is no such media !");
                    } else {
                        cart.removeMedia(item);
                    }
                }
                case 4 -> {
                    System.out.print("CuongPQ - 5604: Enter media's title: ");
                    String title = scanner.nextLine();
                    Media item = cart.searchByTitle(title);
                    if (item == null) {
                        System.out.println("There is no such media !");
                    } else {
                        if (item instanceof DigitalVideoDisc dvd) {
                            try {
                                dvd.play();
                            } catch (PlayerException e) {
                                System.out.println("Error: " + e.getMessage());
                            }
                        }
                        if (item instanceof CompactDisc cd) {
                            if (((CompactDisc) item).getTracks().isEmpty()) {
                                System.out.println("This CD has no track, can't play !");
                            } else {
                                try {
                                    cd.play();
                                } catch (PlayerException e) {
                                    System.out.println("Error: " + e.getMessage());
                                }
                            }
                        }
                    }
                }
                case 5 -> {
                    System.out.println("Your cart has been paid\nThanks for using our service");
                    cart.emptyCart();
                }
            }
        }
    }

    public static int getOption(Scanner scanner) {
        try {
            return inputInt(scanner);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input, please enter a number");
            scanner.nextLine();
            return getOption(scanner);
        }
    }

    public static int inputInt(Scanner scanner) {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input, please enter a number");
            scanner.nextLine();
            return inputInt(scanner);
        }
    }

    public static float inputFloat(Scanner scanner) {
        try {
            return scanner.nextFloat();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input, please enter a number");
            scanner.nextLine();
            return inputFloat(scanner);
        }
    }
}