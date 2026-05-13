package de.htw_berlin.mytodolist;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class Controller {

    private final List<FootworkSession> sessions = new ArrayList<>();
    private final AtomicLong nextId = new AtomicLong(1);

    @GetMapping("/sessions")
    public List<FootworkSession> getAllSessions() {
        return sessions;
    }

    @PostMapping("/sessions")
    @ResponseStatus(HttpStatus.CREATED)
    public FootworkSession createSession(@RequestBody FootworkSession session) {
        session.setId(nextId.getAndIncrement());
        sessions.add(session);
        return session;
    }

    @PutMapping("/sessions/{id}")
    public FootworkSession updateSession(@PathVariable Long id, @RequestBody FootworkSession updated) {
        for (FootworkSession session : sessions) {
            if (session.getId().equals(id)) {
                session.setWorkTime(updated.getWorkTime());
                session.setRestTime(updated.getRestTime());
                session.setRound(updated.getRound());
                return session;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/sessions/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSession(@PathVariable Long id) {
        boolean removed = sessions.removeIf(s -> s.getId().equals(id));
        if (!removed) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
