package com.example;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.*;

@WebListener
public class AppSessionListener implements HttpSessionAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        if ("inputString".equals(event.getName())) {
            System.out.println("ATTRIBUTE ADDED: " + event.getName() +
                    " = " + event.getValue());
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        if ("inputString".equals(event.getName())) {
            System.out.println("ATTRIBUTE REMOVED: " + event.getName());
        }
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        if ("inputString".equals(event.getName())) {
            HttpSession session = event.getSession();
            Object newVal = session.getAttribute("inputString");
            System.out.println("ATTRIBUTE REPLACED: " + event.getName() +
                    " new value = " + newVal);
        }
    }
}
