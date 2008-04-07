package com.verticon.tracker.fair.editor.presentation;

import java.awt.print.Book;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.swt.internal.Library;

import com.verticon.tracker.fair.Fair;

class MyContentAdapter extends org.eclipse.emf.ecore.util.EContentAdapter {

    // start observing a Library model
    public void observeLibrary(Fair l){
        l.eAdapters().add(this);
    }

    //override the notifyChanged method
    public void notifyChanged(Notification n){
        
        super.notifyChanged(n); // the superclass handles adding/removing this Adapter to new Books
        
        // find out the type of the notifier which could be either 'Book' or 'Library'
        Object notifier = n.getNotifier();
        if (notifier instanceof Fair) {
//            handleLibraryNotification(n);
        } else if (notifier instanceof Book) {
//            handleBookNotification(n);
        }
    }

//    // output a message about new books
//    private void handleLibraryNotification(Notification n){
//        int featureID = n.getFeatureID(org.example.library.Library.class);
//        if (featureID == org.example.library.LibraryPackage.LIBRARY__BOOKS){
//            if (n.getEventType() == Notification.ADD){
//                Book b = (Book) n.getNewValue(); 
//                System.out.println("New Book was added to the Library: + " b.getTitle());
//            }
//        }
//    }
//
//    // output a message about a book´s availability
//    private void handleBookNotification(Notification n){
//        int featureID = n.getFeatureID(org.example.library.Book.class);
//        if (featureID == org.example.library.LibraryPackage.BOOK__AVAILABLE){
//                Book b = (Book) n.getNotifier();
//                System.out.println("The book " + b.getTitle() + " is now " + (b.isAvailable() ? "available" : "unavailable"));
//        }
//    }
}