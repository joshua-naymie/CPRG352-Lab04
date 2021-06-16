/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
/**
 *
 * @author Main
 */
public class Note implements Serializable
{
    private static final
    String EMPTY_STRING = "";
    
    private
    String title,
           content;
    
    //----------------------------------------
    
    public Note()
    {
        setTitle(EMPTY_STRING);
        setContent(EMPTY_STRING);
    }

    //--------------------
    
    public Note(String title, String content)
    {
        setTitle(title);
        setContent(content);
    }
    
    //----------------------------------------
    
    private void setTitle(String title)
    {
        this.title = title;
    }
    
    //--------------------
    
    public String getTitle()
    {
        return title;
    }
    
    //----------------------------------------
    
    private void setContent(String content)
    {
        this.content = content.replace("\n", "<br>").replace("\r", EMPTY_STRING);
    }
    
    //--------------------
    
    public String getContent()
    {
        return content.replace("<br>", "\n");
    }
    
    public String getHtmlContent()
    {
        return content;
    }
}
