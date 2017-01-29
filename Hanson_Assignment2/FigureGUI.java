import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.GregorianCalendar;
import java.util.List;
import java.awt.BorderLayout;
import java.lang.String;
import javax.swing.*;

/**
 * This class builds a window based interface for a program
 * that draws colored shapes and saves the file.
 *
 * @author Chelsea Hanson
 */
public class FigureGUI extends JFrame implements ActionListener {

    // This program is limited as of now to two different drawn shapes.
	private enum Action { RECTANGLE, CIRCLE }

	private JButton redButton = new JButton("Red");
	private JButton greenButton = new JButton("Green");
	private JButton blueButton = new JButton("Blue");
	private JButton rectangleButton = new JButton("Rectangle");
	private JButton circleButton = new JButton("Circle");
	private JButton exitButton = new JButton("Exit");
	
	private JTextArea listArea = new JTextArea(10, 10);

	private GregorianCalendar currentDate = new GregorianCalendar();
	
	private FiguresPanel figuresPanel = new FiguresPanel();
    Graphics g = figuresPanel.getGraphics();


	private Action action = Action.RECTANGLE;
    private Color selectedColor = Color.red;
	private String formattedDate;



    private static boolean isFirstClick = true;
    private int startX;
    private int startY;
    private int endX;
    private int endY;
    private int height;
    private int width;
    private int radius;
    private int centerX;
    private int centerY;

    protected List<Figure> figuresList = new ArrayList<Figure>();

    /**
     * This inner class sets up and controls the area that shapes are to be drawn in.
     *
     */
    public class FiguresPanel extends JPanel implements MouseListener {


        /**
         * Fills the graphics panel with the designated designs,
         * and adds a date stamp to it.
         *
         * @param g The "paintbrush" for drawing graphics.
         */
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            // draw all figures
            for (int i = 0; i < figuresList.size(); i++){
                Figure temp = figuresList.get(i);
                g.setColor(temp.color);
                temp.draw(g);
            }

            // put the date
            g.setColor(Color.black);
            g.drawString(formattedDate, 25, 340);
        }

        /**
         * Waits for the mouse click and creates the appropriate figures.
         */
        @Override
        public void mouseClicked(MouseEvent event) {
            switch(action) {
                case RECTANGLE:
                    if (isFirstClick){
                        startX = event.getX();
                        startY = event.getY();
                        isFirstClick = false;
                    }
                    else{
                        endX = event.getX();
                        endY = event.getY();
                        width = Math.abs(endX - startX);
                        height = Math.abs(endY - startY);
                        if (startX > endX){
                            startX = endX;
                        }
                        if (startY > endY){
                            startY = endY;
                        }
                        Figure rectangle = new Rectangle(startX, startY, width, height, selectedColor);
                        figuresList.add(rectangle);
                        listArea.append(rectangle.toString());
                        isFirstClick = true;
                        repaint();
                    }
                    break;
                case CIRCLE:
                    if (isFirstClick){
                        startX = event.getX();
                        startY = event.getY();
                        isFirstClick = false;

                    }
                    else{
                        endX = event.getX();
                        endY = event.getY();
                        radius = (int)Math.sqrt(Math.pow((Math.abs(endX - startX)), 2) + (Math.pow((Math.abs(endY - startY)), 2)));
                        centerX = (startX + endX)/2;
                        centerY = (startY + endY)/2;
                        startX = centerX - radius/2;
                        startY = centerY - radius/2;
                        Figure circle = new Circle(centerX, centerY, radius, selectedColor);
                        figuresList.add(circle);
                        listArea.append(circle.toString());
                        isFirstClick = true;
                        repaint();
                    }
                    break;
            }
		}

		/**
		 * Not used
		 */
		@Override
		public void mouseEntered(MouseEvent arg0) {
		}

		/**
		 * Not used
		 */
		@Override
		public void mouseExited(MouseEvent arg0) {
		}

		/**
		 * Not used
		 */
		@Override
		public void mousePressed(MouseEvent arg0) {
		}

		/**
		 * Not used
		 */
		@Override
		public void mouseReleased(MouseEvent arg0) {
		}

	}

	/**
	 * Sets up the entire interface.
	 */
	public FigureGUI() {
		super("Figures GUI");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

		JPanel buttonPanel = new JPanel(new GridLayout(2, 3));
		JPanel listPanel = new JPanel(new GridLayout(1, 1));
		JPanel mainPanel = new JPanel(new GridLayout(1, 4));

		buttonPanel.add(redButton);
		buttonPanel.add(greenButton);
		buttonPanel.add(blueButton);
		buttonPanel.add(rectangleButton);
		buttonPanel.add(circleButton);
		buttonPanel.add(exitButton);

		listPanel.add(new JScrollPane(listArea));

		mainPanel.add(figuresPanel);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        formattedDate = dateFormat.format(currentDate.getTime());
        figuresPanel.setLayout(new BorderLayout());

		redButton.addActionListener(this);
        greenButton.addActionListener(this);
        blueButton.addActionListener(this);
        rectangleButton.addActionListener(this);
        circleButton.addActionListener(this);
        exitButton.addActionListener(this);
		figuresPanel.addMouseListener(figuresPanel);

        try {
            FileInputStream fileIn = new FileInputStream("figures");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            while (in.readObject() != null) {
                System.out.println("Read in: \n" + in.readObject());
                Object temp = new Object();
                temp = (Figure)in.readObject();
                figuresList.add((Figure) in.readObject());
                listArea.append(((Figure) in.readObject()).toString());
            }
        }
        catch (IOException e){
            System.out.print("");
        }
        catch (ClassNotFoundException c){
            System.out.println("This file does not contain Figures.");
        }

		this.getContentPane().setLayout(new GridLayout(1, 3));
		this.getContentPane().add(figuresPanel);
		this.getContentPane().add(buttonPanel);
		this.getContentPane().add(listPanel);


	}

    /**
	 * Listener for all buttons. 
	 */
	@Override
	public void actionPerformed(ActionEvent event){
		if (event.getSource() == redButton){
            selectedColor = Color.red;
        }
        else if (event.getSource() == greenButton){
            selectedColor = Color.green;
        }
        else if (event.getSource() == blueButton) {
            selectedColor = Color.blue;
        }
        else if (event.getSource() == rectangleButton) {
            action = Action.RECTANGLE;
        }
        else if (event.getSource() == circleButton) {
            action = Action.CIRCLE;
        }
        else if (event.getSource() == exitButton) {
            try {
                this.saveAndExit();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
	}

    /**
     * This method saves the drawn objects to a file
     * and closes the program.
     */
    public void saveAndExit() throws IOException{
        try {
            FileOutputStream fileOut = new FileOutputStream("figures");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            for (int i = 0; i < figuresList.size(); i++) {
                out.writeObject(figuresList.get(i));
                System.out.println("Write to file: \n" + figuresList.get(i));
            }

            out.close();
            fileOut.close();
        }
        catch(IOException e) {
            System.out.println("Objects could not be written to the file.");
        }

        System.exit(0);
    }

	/**
	 * The method creates an FigureGUI object.
	 *
	 * @param args not used
	 */
	public static void main(String[] args) {
		FigureGUI gui = new FigureGUI();
		gui.setSize(1000, 400);
		gui.setResizable(false);
		gui.setVisible(true);
	}
}