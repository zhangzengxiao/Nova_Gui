/**
 * 
 */
package jsi.nova.gui.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Point;
import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.TransferHandler;

import com.mxgraph.model.mxCell;
import com.mxgraph.model.mxGeometry;
import com.mxgraph.swing.util.mxGraphTransferable;
import com.mxgraph.swing.util.mxSwingConstants;
import com.mxgraph.util.mxEvent;
import com.mxgraph.util.mxEventObject;
import com.mxgraph.util.mxEventSource;
import com.mxgraph.util.mxRectangle;

import jsi.nova.jgraphx.CommandsCell;
import jsi.nova.jgraphx.InnerGraphCell;
import jsi.nova.jgraphx.ShadowBorder;


/**
 * @ClassName:     CellsPanel.java
 * @Description:   TODO(用一句话描述该文件做什么) 
 * @author         zhangzengxiao
 * @version        V1.0  
 * @Date           2017年12月26日 下午1:58:02 
 * @Place          北京航空航天大学中德软件联合研究所
 */
public class CellsPanel extends JPanel {
    
    protected JLabel selectedEntry = null;
    protected mxEventSource eventSource = new mxEventSource(this);

    public CellsPanel() {
        // TODO Auto-generated constructor stub
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.add(scrollPane);
        
        this.addCommandsCell("Commands", new ImageIcon("./img/rounded.png"), "image;image=/img/server.png", 80, 50, "");
        this.addInnerGraphCell("InnerGraph", new ImageIcon("./img/triangle.png"), "image;image=/img/server.png", 80, 50, "");

        setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));

        // Clears the current selection when the background is clicked
        addMouseListener(new MouseListener()
        {

                public void mousePressed(MouseEvent e)
                {
                        clearSelection();
                }
                
                public void mouseClicked(MouseEvent e)
                {
                }
                
                public void mouseEntered(MouseEvent e)
                {
                }
                
                public void mouseExited(MouseEvent e)
                {
                }

                public void mouseReleased(MouseEvent e)
                {
                }

        });

        // Shows a nice icon for drag and drop but doesn't import anything
        setTransferHandler(new TransferHandler()
        {
                public boolean canImport(JComponent comp, DataFlavor[] flavors)
                {
                        return true;
                }
        });
    }

//    public void addTemplate(final String name, ImageIcon icon, String style, int width, int height, Object value) {
//        mxCell cell = new mxCell(value, new mxGeometry(0, 0, width, height), style);
//        cell.setVertex(true);
//
//        addTemplate(name, icon, cell);
//    }
    public void addCommandsCell(final String name, ImageIcon icon, String style, int width, int height, Object value) {
        CommandsCell cell = new CommandsCell(value, new mxGeometry(0, 0, width, height), style);
        cell.setVertex(true);
        addTemplate(name, icon, cell);
    }
    public void addInnerGraphCell(final String name, ImageIcon icon, String style, int width, int height, Object value) {
        InnerGraphCell cell = new InnerGraphCell(value, new mxGeometry(0, 0, width, height), style);
        cell.setVertex(true);
        addTemplate(name, icon, cell);
    }

    public void addTemplate(final String name, ImageIcon icon, mxCell cell) {
        mxRectangle bounds = (mxGeometry) cell.getGeometry().clone();
        final mxGraphTransferable t = new mxGraphTransferable(new Object[] { cell }, bounds);

        // Scales the image if it's too large for the library
        if (icon != null) {
            if (icon.getIconWidth() > 32 || icon.getIconHeight() > 32) {
                icon = new ImageIcon(icon.getImage().getScaledInstance(32, 32, 0));
            }
        }

        final JLabel entry = new JLabel(icon);
        entry.setPreferredSize(new Dimension(50, 50));
        entry.setFont(new Font(entry.getFont().getFamily(), 0, 10));

        entry.setVerticalTextPosition(JLabel.BOTTOM);
        entry.setHorizontalTextPosition(JLabel.CENTER);
        entry.setIconTextGap(0);

        entry.setToolTipText(name);
        entry.setText(name);

        entry.addMouseListener(new MouseListener() {

            public void mousePressed(MouseEvent e) {
                setSelectionEntry(entry, t);
            }

            public void mouseClicked(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }

            public void mouseReleased(MouseEvent e) {
            }

        });

        // Install the handler for dragging nodes into a graph
        DragGestureListener dragGestureListener = new DragGestureListener() {
            /**
             * 
             */
            public void dragGestureRecognized(DragGestureEvent e) {
                e.startDrag(null, mxSwingConstants.EMPTY_IMAGE, new Point(), t, null);
            }

        };

        DragSource dragSource = new DragSource();
        dragSource.createDefaultDragGestureRecognizer(entry, DnDConstants.ACTION_COPY, dragGestureListener);

        add(entry);
    }

    public void setSelectionEntry(JLabel entry, mxGraphTransferable t) {
        JLabel previous = selectedEntry;
        selectedEntry = entry;

        if (previous != null) {
            previous.setBorder(null);
            previous.setOpaque(false);
        }

        if (selectedEntry != null) {
            selectedEntry.setBorder(ShadowBorder.getSharedInstance());
            selectedEntry.setOpaque(true);
        }

        eventSource.fireEvent(
                new mxEventObject(mxEvent.SELECT, "entry", selectedEntry, "transferable", t, "previous", previous));
    }

    public void clearSelection() {
        setSelectionEntry(null, null);
    }

}
