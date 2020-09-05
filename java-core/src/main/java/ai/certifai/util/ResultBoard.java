package ai.certifai.util;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/***
 * Result Dashboard to view results
 *
 * @author Chiawei Lim
 */
public class ResultBoard
{
    private Font font;
    private Integer counter = 1;
    private String bufferPass = "                 ";
    private String bufferFail = "                  ";
    private Color foregroundColor = Color.WHITE;
    private Integer frameHeight = 100;

    public ResultBoard()
    {
        font = new Font("SansSerif", Font.BOLD, 16);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
    }

    public void display(java.util.List<Boolean> listResults)
    {

        System.out.println(listResults.size());

        JFrame resultBoard = new JFrame("Result Board");
        JPanel boardPanel  = new JPanel();

        for(Boolean result : listResults)
        {
            boardPanel.add(getCounter());
            boardPanel.add(getText(result));
            frameHeight += 35;
        }

        boardPanel.add(getCloseButton());

        resultBoard.add(boardPanel);
        resultBoard.setLocationRelativeTo(null);
        resultBoard.setSize(290, frameHeight);
        resultBoard.setBounds(0, 0, 290, frameHeight);


        resultBoard.setResizable(false);
        resultBoard.setVisible(true);

    }

    public JButton getCloseButton()
    {
        JButton button = new JButton("Close");
        button.setFont(font);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        return button;
    }

    public JLabel getCounter()
    {
        JLabel counterLabel = new JLabel((counter++) + ".    ");
        counterLabel.setFont(font);
        counterLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        return counterLabel;
    }

    public JTextField getText(Boolean isCorrect)
    {
        String message;
        Color backgroundColor;

        if(isCorrect)
        {
            message = bufferPass + "PASSED" + bufferPass;
            backgroundColor = Color.GREEN;
        }
        else
        {
            message = bufferFail + "FAILED" + bufferFail;
            backgroundColor = Color.RED;
        }

        JTextField field = new JTextField(message);

        field.setFont(font);
        field.setForeground(foregroundColor);
        field.setBackground(backgroundColor);
        field.setAlignmentX(Component.CENTER_ALIGNMENT);
        field.setEditable(false);

        return field;
    }

}