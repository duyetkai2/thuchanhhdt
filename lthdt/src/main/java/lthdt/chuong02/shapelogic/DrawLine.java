/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lthdt.chuong02.shapelogic;
import java.awt.Graphics2D;
/**
 *
 * @author Admin
 */
public class DrawLine {
    private Graphics2D gr;
    private Line line ;

    public DrawLine() {
    }

    public DrawLine(Graphics2D gr, Line line) {
        this.gr = gr;
        this.line = line;
    }
    public void veDuongThang(){
        gr.drawLine(line.getBegin_x(), line.getBegin_y(),
                line.getEnd_x(), line.getEnd_y());
    
    }

    public void setGR(Graphics2D gr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setLine(Line line) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
    
}
