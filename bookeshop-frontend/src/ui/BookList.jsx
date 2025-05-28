import React, { useEffect, useState } from 'react';
import { fetchBooks } from '../repository/bookRepository';

const BookList = () => {
    const [books, setBooks] = useState([]);
    const [page, setPage] = useState(0);
    const [totalPages, setTotalPages] = useState(1);

    useEffect(() => {
        fetchBooks(page).then((res) => {
            setBooks(res.data.content);
            setTotalPages(res.data.totalPages);
        });
    }, [page]);

    return (
        <div>
            <h2>Book List</h2>
            <ul>
                {books.map((book) => (
                    <li key={book.id}>{book.title} by {book.author}</li>
                ))}
            </ul>

            <div>
                <button onClick={() => setPage((p) => Math.max(p - 1, 0))} disabled={page === 0}>
                    Previous
                </button>
                <span> Page {page + 1} of {totalPages} </span>
                <button onClick={() => setPage((p) => Math.min(p + 1, totalPages - 1))} disabled={page + 1 >= totalPages}>
                    Next
                </button>
            </div>
        </div>
    );
};

export default BookList;
