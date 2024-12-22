// Pham Quoc Cuong - 20225604
package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.cart.Cart;

import javax.swing.*;
import java.awt.*;

public class MediaStore extends JPanel {
    public MediaStore(Media media, Cart myCart) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(),Font.PLAIN,20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" +media.getCost() + "$");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton btnAdd = new JButton("Add to cart");
        container.add(btnAdd);
        btnAdd.addActionListener(e -> myCart.addMedia(media));

        if(media instanceof Playable) {
            JButton playBtn= new JButton("Play");
            playBtn.addActionListener(e -> {
                JDialog playDialog = createPlayDialog(media);
                playDialog.setVisible(true);
                playDialog.setSize(300,200);
                playDialog.pack();
            });
            container.add(playBtn);
        }
        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    static JDialog createPlayDialog(Media media) {
        try {
            JDialog playDialog = new JDialog();
            Container container = playDialog.getContentPane();
            playDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
            container.add(Box.createRigidArea(new Dimension(10, 10)));
            if (media instanceof DigitalVideoDisc dvd) {
                try {
                    dvd.play();
                    container.add(new JLabel("Cuong PQ 5604: Playing DVD:" + dvd.getTitle()));
                    container.add(new JLabel("Cuong PQ 5604: DVD length:" + dvd.getLength() + " min"));
                } catch (PlayerException e) {
                    JOptionPane.showMessageDialog(playDialog, "Cuong PQ 5604: Error: " + e.getMessage(), "Player Error", JOptionPane.ERROR_MESSAGE);
                }
            } else if (media instanceof CompactDisc cd) {
                try {
                    cd.play();
                    container.add(new JLabel("Cuong PQ 5604: Title: " + cd.getTitle()));
                    container.add(new JLabel("Cuong PQ 5604: Artist: " + cd.getArtist()));
                    for (Track track : cd.getTracks()) {
                        container.add(new JLabel("Cuong PQ 5604: Play: " + track.getTitle() + ". Length: " + track.getLength() + " min"));
                    }
                } catch (PlayerException e) {
                    JOptionPane.showMessageDialog(playDialog, "Cuong PQ 5604: Error: " + e.getMessage(), "Player Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            playDialog.setTitle("Play " + media.getTitle());
            return playDialog;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cuong PQ 5604: Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}