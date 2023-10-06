package com.example.chatapp.firestore.dao

import com.example.chatapp.firestore.model.User
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

object UsersDao {
    fun getUsersCollection(): CollectionReference {
        val database = Firebase.firestore
        return database.collection("users")
    }

    fun createUser(user: User, onCompleteListener: OnCompleteListener<Void>) {

        val documentRef = getUsersCollection().document(user.id ?: "")
        documentRef.set(user)
            .addOnCompleteListener(onCompleteListener)
    }

    fun getUser(uid: String?, onCompleteListener: OnCompleteListener<DocumentSnapshot>) {
        getUsersCollection()
            .document(uid ?: "")
            .get().addOnCompleteListener(onCompleteListener)
    }
}