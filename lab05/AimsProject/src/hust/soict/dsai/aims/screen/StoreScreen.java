package hust.soict.dsai.aims.screen;
import javax.swing.*;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StoreScreen extends JFrame {
    private Store store;
    private Container cp;
    private Cart cart;
    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north,BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");
        JMenu smUpdateStore = new JMenu("CuongPQ 225604 - Update Store");
        JMenuItem addBook = new JMenuItem("CuongPQ 225604 - Add Book");
        smUpdateStore.add(addBook);
        addBook.addActionListener(e -> {
            new AddBookStoreScreen(store);
        });
        JMenuItem addCD = new JMenuItem("CuongPQ 225604 - Add CD");
        smUpdateStore.add(addCD);
        addCD.addActionListener(e -> {
            new AddCDStoreScreen(store);
        });
        JMenuItem addDVD = new JMenuItem("CuongPQ 225604 - Add DVD");
        smUpdateStore.add(addDVD);
        addDVD.addActionListener(e -> {
            new AddDVDStoreScreen(store);
        });
        menu.add(smUpdateStore);
        JMenuItem viewCart = new JMenuItem("View cart");
        viewCart.addActionListener(e -> {
            new CartScreen(cart);
        });
        menu.add(viewCart);
        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header,BoxLayout.X_AXIS));

        JLabel title = new JLabel("CuongPQ 225604 - AIMS");
        title.setFont(new Font(title.getFont().getName(),Font.PLAIN,50));
        title.setForeground(Color.BLACK);

        JButton cart1 = new JButton("View cart");
        cart1.setPreferredSize(new Dimension(100,50));
        cart1.setMaximumSize(new Dimension(100,50));
        cart1.addActionListener(e -> {
            new CartScreen(cart);
        });

        header.add(Box.createRigidArea(new Dimension(10,10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cart1);
        header.add(Box.createRigidArea(new Dimension(10,10)));
        return header;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3,3,2,2));
        ArrayList<Media> mediaStore = store.getItemsInStore();
        for(Media media : mediaStore) {
            MediaStore cell = new MediaStore(media,cart);
            center.add(cell);
        }
        return center;
    }

    public StoreScreen(Store store, Cart myCart) {
        this.store  = store;
        this.cart = myCart;
        cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(),BorderLayout.NORTH);
        cp.add(createCenter(),BorderLayout.CENTER);
        setVisible(true);
        setTitle("20225604 - Store");
        setSize(1024,768);
    }

    private class AddBookStoreScreen extends JFrame {
        public AddBookStoreScreen(Store store) {
            this.setLayout(new GridLayout(5, 2, 5, 5));
            this.add(new JLabel("Enter title: "));
            TextField title = new TextField(10);
            this.add(title);
            this.add(new JLabel("Enter category: "));
            TextField category = new TextField(10);
            this.add(category);
            this.add(new JLabel("Enter cost: "));
            TextField cost = new TextField(10);
            this.add(cost);
            this.add(new JLabel("Enter authors: "));
            TextField authors = new TextField(10);
            this.add(authors);

            this.setTitle("Add Book");
            this.setSize(300, 150);
            JButton turnInBtn = new JButton("Add");
            this.add(turnInBtn);
            turnInBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ArrayList<String> authorList = new ArrayList<>();
                    for (String author : authors.getText().split(",")) {
                        authorList.add(author.trim());
                    }
                    Book book = new Book(title.getText(), category.getText(), Float.parseFloat(cost.getText()), authorList);
                    store.addMedia(book);
                    cp.add(createCenter(), BorderLayout.CENTER);
                    cp.revalidate();
                    title.setText("");
                    category.setText("");
                    cost.setText("");
                    authors.setText("");
                }
            });
            setVisible(true);
        }
    }

    private class AddDVDStoreScreen extends JFrame {
        public AddDVDStoreScreen(Store store) {
            this.setLayout(new GridLayout(4, 2, 5, 5));
            this.add(new JLabel("Enter title: "));
            TextField title = new TextField(10);
            this.add(title);
            this.add(new JLabel("Enter category: "));
            TextField category = new TextField(10);
            this.add(category);
            this.add(new JLabel("Enter cost: "));
            TextField cost = new TextField(10);
            this.add(cost);

            this.setTitle("Add DVD");
            this.setSize(300, 100);
            JButton turnInBtn = new JButton("Add");
            this.add(turnInBtn);
            turnInBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    DigitalVideoDisc dvd = new DigitalVideoDisc(title.getText(), category.getText(), Float.parseFloat(cost.getText()));
                    store.addMedia(dvd);
                    cp.add(createCenter(), BorderLayout.CENTER);
                    cp.revalidate();
                    title.setText("");
                    category.setText("");
                    cost.setText("");
                }
            });
            setVisible(true);
        }
    }

    private class AddCDStoreScreen extends JFrame {
        public AddCDStoreScreen(Store store) {
            this.setLayout(new GridLayout(7, 2, 5, 5));
            this.add(new JLabel("Enter title: "));
            TextField title = new TextField(10);
            this.add(title);
            this.add(new JLabel("Enter category: "));
            TextField category = new TextField(10);
            this.add(category);
            this.add(new JLabel("Enter cost: "));
            TextField cost = new TextField(10);
            this.add(cost);
            this.add(new JLabel("Enter artist: "));
            TextField artist = new TextField(10);
            this.add(artist);
            this.setTitle("Add CD");
            this.add(new JLabel("Number of tracks: "));
            TextField numberOfTracks = new TextField(10);
            this.add(numberOfTracks);
            this.pack();
            JButton turnInBtn = new JButton("Add");
            this.add(turnInBtn);
            turnInBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    CompactDisc cd = new CompactDisc(title.getText(), category.getText(), artist.getText(), new ArrayList<Track>(), Float.parseFloat(cost.getText()));
                    store.addMedia(cd);
                    cp.add(createCenter(), BorderLayout.CENTER);
                    cp.revalidate();
                    title.setText("");
                    category.setText("");
                    cost.setText("");
                }
            });
            setVisible(true);
        }
    }

    public static void main(String[] args) {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Disney", 15, 89);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Inception", "Sci-Fi", "Christopher Nolan", 20, 148);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("The Dark Knight", "Action", "Christopher Nolan", 25, 152);

        ArrayList<Track> tracks1 = new ArrayList<Track>();
        tracks1.add(new Track("Bohemian Rhapsody", 6));
        tracks1.add(new Track("Stairway to Heaven", 8));
        CompactDisc cd1 = new CompactDisc("Classic Rock", "Rock", "Various Artists", tracks1, 25.0f);

        ArrayList<Track> tracks2 = new ArrayList<Track>();
        tracks2.add(new Track("Blinding Lights", 3));
        tracks2.add(new Track("Save Your Tears", 4));
        tracks2.add(new Track("In Your Eyes", 4));
        CompactDisc cd2 = new CompactDisc("The Weeknd Hits", "Pop", "The Weeknd", tracks2, 30.0f);

        ArrayList<String> authors1 = new ArrayList<String>();
        authors1.add("J.K. Rowling");
        Book book1 = new Book("Harry Potter and the Philosopher's Stone", "Fantasy", 20.0f, authors1);
        tracks2.add(new Track("Deamn - Sign", 4));
        tracks2.add(new Track("MBB - Arrival", 3));
        tracks2.add(new Track("EnV - Pneumatic", 5));
        CompactDisc cd3 = new CompactDisc("Addictive EDM Music", "International Music", "Various Artists", tracks2, 37.25f);

        ArrayList<String> authors3 = new ArrayList<String>();
        authors3.add("Agatha Christie");
        Book book3 = new Book("And Then There Were None", "Detective", 25.2f, authors1);

        ArrayList<String> authors2 = new ArrayList<String>();
        authors2.add("Phung Quan");
        Book book2 = new Book("The Savage Childhood", "Novel", 27.45f, authors2);

        Store store = new Store();

        store.addMedia(cd1);
        store.addMedia(cd2);
        store.addMedia(cd3);
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(book1);
        store.addMedia(book2);
        store.addMedia(book3);
        

        Cart myCart = new Cart();
        new StoreScreen(store, myCart);
    }
}