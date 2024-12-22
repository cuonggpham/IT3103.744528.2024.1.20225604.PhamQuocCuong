// Pham Quoc Cuong - 20225604
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
    private JButton btnSortCost;
    private JButton btnSortTitle;

    // Constructor
    public StoreScreen(Store store, Cart myCart) {
        this.store = store;
        this.cart = myCart;
        cp = getContentPane();
        cp.setLayout(new BorderLayout());

        JPanel northPanel = createNorth();
        cp.add(northPanel, BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        // Remove sort buttons from here
        // btnSortCost = new JButton("Sort by Cost");
        // btnSortTitle = new JButton("Sort by Title");
        // northPanel.add(btnSortCost);
        // northPanel.add(btnSortTitle);

        setTitle("Store");
        setSize(1024, 768);
        setVisible(true);
    }

    // Tạo phần header
    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");
        JMenu smUpdateStore = new JMenu("Update Store");
        // Add Book option
        JMenuItem addBook = new JMenuItem("Add Book");
        addBook.addActionListener(e -> new AddBookStoreScreen(store));
        smUpdateStore.add(addBook);

        // Add DVD option
        JMenuItem addDVD = new JMenuItem("Add DVD");
        addDVD.addActionListener(e -> new AddDVDStoreScreen(store));
        smUpdateStore.add(addDVD);

        // Add CD option
        JMenuItem addCD = new JMenuItem("Add CD");
        addCD.addActionListener(e -> new AddCDStoreScreen(store));
        smUpdateStore.add(addCD);

        // Remove Media option
        JMenuItem removeMedia = new JMenuItem("Remove Media");
        removeMedia.addActionListener(e -> new RemoveMediaStoreScreen(store));
        smUpdateStore.add(removeMedia);

        menu.add(smUpdateStore);

        // View Cart Option
        JMenuItem viewCart = new JMenuItem("View Cart");
        viewCart.addActionListener(e -> new CartScreen(cart));
        menu.add(viewCart);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("CuongPQ - AIMS Store");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.ORANGE);

        JButton cartBtn = new JButton("View Cart");
        cartBtn.setPreferredSize(new Dimension(100, 50));
        cartBtn.addActionListener(e -> new CartScreen(cart));

        btnSortCost = new JButton("Sort by Cost");
        btnSortTitle = new JButton("Sort by Title");
        btnSortCost.addActionListener(e -> {
            store.getItemsInStore().sort(Media.COMPARE_BY_COST_TITLE);
            cp.add(createCenter(), BorderLayout.CENTER);
            cp.revalidate();
        });
        btnSortTitle.addActionListener(e -> {
            store.getItemsInStore().sort(Media.COMPARE_BY_TITLE_COST);
            cp.add(createCenter(), BorderLayout.CENTER);
            cp.revalidate();
        });

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(btnSortCost);
        header.add(btnSortTitle);
        header.add(Box.createRigidArea(new Dimension(20, 20))); // Add gap between sort buttons and cart button
        header.add(cartBtn);
        header.add(Box.createRigidArea(new Dimension(10, 10)));
        return header;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        ArrayList<Media> mediaStore = store.getItemsInStore();
        for (Media media : mediaStore) {
            MediaStore cell = new MediaStore(media, cart);
            center.add(cell);
        }
        return center;
    }
    
    // Add Book Dialog Class
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
                    try {
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
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Cuong PQ 5604: Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            setVisible(true);
        }
    }

    private class AddDVDStoreScreen extends JFrame {
        public AddDVDStoreScreen(Store store) {
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
            this.add(new JLabel("Enter length: "));
            TextField length = new TextField(10);
            this.add(length);

            this.setTitle("Add DVD");
            this.setSize(300, 100);
            JButton turnInBtn = new JButton("Add");
            this.add(turnInBtn);
            turnInBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        DigitalVideoDisc dvd = new DigitalVideoDisc(title.getText(), category.getText(), "", Integer.parseInt(length.getText()), Float.parseFloat(cost.getText()));
                        store.addMedia(dvd);
                        cp.add(createCenter(), BorderLayout.CENTER);
                        cp.revalidate();
                        title.setText("");
                        category.setText("");
                        cost.setText("");
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Cuong PQ 5604: Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            setVisible(true);
        }
    }

    private class AddCDStoreScreen extends JFrame {
        public AddCDStoreScreen(Store store) {
            this.setLayout(new GridLayout(8, 2, 5, 5));
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
            this.add(new JLabel("Enter length: "));
            TextField length = new TextField(10);
            this.add(length);


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
                    try {
                        CompactDisc cd = new CompactDisc(title.getText(), category.getText(),"", Integer.parseInt(length.getText()), Float.parseFloat(cost.getText()), artist.getText(), new ArrayList<Track>());
                        store.addMedia(cd);
                        cp.add(createCenter(), BorderLayout.CENTER);
                        cp.revalidate();
                        title.setText("");
                        category.setText("");
                        cost.setText("");
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Cuong PQ 5604: Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            setVisible(true);
        }
    }

    private class RemoveMediaStoreScreen extends JFrame {
        public RemoveMediaStoreScreen(Store store) {
            this.setLayout(new GridLayout(2, 2, 5, 5));
            this.add(new JLabel("Enter title: "));
            TextField title = new TextField(10);
            this.add(title);

            this.setTitle("Remove Media");
            this.setSize(300, 100);
            JButton removeBtn = new JButton("Remove");
            this.add(removeBtn);
            removeBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        Media mediaToRemove = null;
                        for (Media media : store.getItemsInStore()) {
                            if (media.getTitle().equals(title.getText())) {
                                mediaToRemove = media;
                                break;
                            }
                        }
                        if (mediaToRemove != null) {
                            store.removeMedia(mediaToRemove);
                            cp.add(createCenter(), BorderLayout.CENTER);
                            cp.revalidate();
                            title.setText("");
                        } else {
                            JOptionPane.showMessageDialog(null, "Cuong PQ 5604: Media not found", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Cuong PQ 5604: Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            setVisible(true);
        }
    }

    // Main Method
    public static void main(String[] args) {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Mat Biec", "Drama", "Victor Vu", 15, 117);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Hai Phuong", "Action", "Ngo Thanh Van", 20, 98);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Co Ba Sai Gon", "Drama", "Tran Buu Loc", 25, 116);

        ArrayList<Track> tracks1 = new ArrayList<Track>();
        tracks1.add(new Track("Chay Ngay Di", 4));
        tracks1.add(new Track("Lac Troi", 5));
        CompactDisc cd1 = new CompactDisc("Son Tung M-TP Hits", "Pop", "Son Tung M-TP", tracks1, 25.0f);

        ArrayList<Track> tracks2 = new ArrayList<Track>();
        tracks2.add(new Track("Bai Nay Chill Phet", 4));
        tracks2.add(new Track("De Den De Di", 3));
        tracks2.add(new Track("Thang Dien", 4));
        CompactDisc cd2 = new CompactDisc("Den Vau Collection", "Rap", "Den Vau", tracks2, 30.0f);

        ArrayList<String> authors1 = new ArrayList<String>();
        authors1.add("Nguyen Nhat Anh");
        Book book1 = new Book("Cho Toi Mot Ve Di Tuoi Tho", "Novel", 20.0f, authors1);

        ArrayList<Track> tracks3 = new ArrayList<Track>();
        tracks3.add(new Track("Deamn - Sign", 4));
        tracks3.add(new Track("MBB - Arrival", 3));
        tracks3.add(new Track("EnV - Pneumatic", 5));
        CompactDisc cd3 = new CompactDisc("Addictive EDM Music", "International Music", "Various Artists", tracks3, 37.25f);

        ArrayList<String> authors2 = new ArrayList<String>();
        authors2.add("Nguyen Huy Thiep");
        Book book2 = new Book("Tuong Ve Huu", "Short Stories", 27.45f, authors2);

        ArrayList<String> authors3 = new ArrayList<String>();
        authors3.add("Nguyen Ngoc Tu");
        Book book3 = new Book("Canh Dong Bat Tan", "Novel", 25.2f, authors3);

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
