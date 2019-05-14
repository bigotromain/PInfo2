package domain.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import domain.model.Message;

public class MessageServiceImpl implements MessageService {

	@PersistenceContext(unitName = "InmemoryPU")
	private EntityManager em;
	
	// Add a new message (row) to the database
	public void sendMessage(Message message) {
		em.persist(message);
		em.flush();
	};
	
	// Delete a message (row)
	//public void deleteMessage(Message message) {
	//	em.remove(em.contains(message) ? message : em.merge(message));
	//};
	
	// Return an ordered list of messages between 2 users using their Id : This creates a chat
	// SELECT * WHERE (senderId = user1Id AND receiverId = user2Id) OR (senderId = user2Id AND receiverId = user1Id) ORDER BY messageId;
	public List<Message> updateChat(Long user1Id, Long user2Id) {
		TypedQuery<Message> query = em.createQuery("SELECT RECIPIENT WHERE (senderId = user1Id AND receiverId = user2Id) OR (senderId = user2Id AND receiverId = user1Id) ORDER BY messageId", Message.class);	
		List<Message> chat = query.getResultList();
		return chat;
	};
	
	// Return a list of chat, a chat being a list of messages
	public List<List<Message>> updateAllChat(Long userId) {
		return null;
	};
	
}
