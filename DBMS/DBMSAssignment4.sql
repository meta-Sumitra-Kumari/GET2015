USE library_database;


/* 1. Write a SELECT command to display name of those members
who belong to the category as to which member
“Arushi” belongs.

Note: Solve the problem using subquery.
*/

SELECT 
    member_nm
from
    members
where
    category = (SELECT 
        category
    from
        members
    where
        member_nm = 'Sumitra');
        
        /* 2. Write a SELECT command to display information on the books
that have not been returned till date. The information should
include book issue date, title, member name and due date.

Note: Use Correlated Subquery.
*/
INSERT INTO book_issue (accession_no,member_id)
VALUES((SELECT accession_no FROM books where title_id=ALL(SELECT title_id FROM titles where title_nm='PAPER TOWN')),
(SELECT member_id FROM members where member_nm='sumitra'));

-- Checking query
SELECT 
    bi.issue_dt, bi.due_dt, m.member_nm, t.title_nm
from
    book_issue bi
        inner join
    books b ON bi.accession_no = b.accession_no
        inner join
    titles t ON b.title_id = t.title_id
        inner join
    members m  ON bi.member_id = m.member_id where bi.accession_no = (SELECT bi1.accession_no from book_issue bi1  where bi1.accession_no= bi.accession_no AND bi1.accession_no NOT IN ( SELECT br.accession_no from book_return br) );
    
    
/*  3. Write a SELECT command to display information on the books
that have been returned after their due dates. The information
should include book issue date, title, member name and due
date.
Note: Use Correlated Subquery.
*/
SELECT 
   bi.Issue_dt, t.Title_nm, m.Member_nm, bi.Due_dt
FROM
   book_Issue bi
       INNER JOIN
   books b ON b.Accession_no = bi.Accession_no
       INNER JOIN
   titles t ON t.Title_id = b.title_id
       INNER JOIN
   Members m ON m.Member_id = bi.Member_id
WHERE
   EXISTS( SELECT 
       br.member_id, br.issue_dt, br.accession_no
   FROM
       book_return br
   WHERE
       br.issue_dt = DATE(bi.issue_dt) AND br.member_id = bi.member_id 
       AND br.accession_no = bi.accession_no 
       AND br.Return_dt > bi.Due_Dt);
