package com.example.demo;

import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
@Service
public class CrudService {
	Firestore firestore = FirestoreClient.getFirestore();
	public String createCRUD(Crud crud) throws InterruptedException, ExecutionException {
		
		ApiFuture<WriteResult> collecApiFuture = firestore.collection("crud_user").document(crud.getName()).set(crud);
		return collecApiFuture.get().getUpdateTime().toString();
	}

	public Crud getCRUD(String docId) throws InterruptedException, ExecutionException {
		DocumentReference documentReference = firestore.collection("crud_user").document(docId);
		ApiFuture<DocumentSnapshot> future = documentReference.get();
		DocumentSnapshot document=future.get();
		Crud crud;
		if (document.exists()) {
			crud = document.toObject(Crud.class);
			return crud;
		}
		return null;
	}

	public String updateCRUD(Crud crud) throws InterruptedException, ExecutionException {
		ApiFuture<WriteResult> collApiFuture = firestore.collection("crud_user").document(crud.getDocId()).set(crud);
		return collApiFuture.get().getUpdateTime().toString(); 
		}

	public String deleteCRUD(String docId) {
		ApiFuture<WriteResult> writeResult = firestore.collection("crud_user").document(docId).delete();
		return "deleted : "+docId;
	}

}
