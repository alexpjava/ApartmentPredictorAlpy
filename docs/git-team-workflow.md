# Git Team Workflow – Official Rules

## Purpose
Ensure that **local and remote repositories remain identical**, with a **clean and predictable history**, while working collaboratively using **feature branches**.

---

## Core Principles
- The **remote repository is the source of truth**
- No accidental merges
- Clean, linear history
- Feature branches are short-lived and focused

---

## Protected Branches
The following branches are **protected**:
- `main`
- `develop`

Rules:
- ❌ No direct commits
- ✅ Changes must go through Pull Requests
- ✅ CI and code review required

---

## Feature Branch Rules
- Naming convention: `feature/<short-description>`
  - Example: `feature/calculation-renovation-cost`
- A feature branch is owned by **one developer** or **explicitly coordinated**
- Rebase is allowed on feature branches
- Never rebase shared branches without coordination

---

## Creating a Feature Branch
```bash
git checkout develop
git pull --ff-only
git checkout -b feature/my-feature
git push -u origin feature/my-feature
```

---

## Daily Work
```bash
git add .
git commit -m "Clear, descriptive commit message"
git push
```

Local and remote must always remain identical after pushing.

---

## Keeping a Feature Branch Up to Date
⚠️ Do NOT use `git pull` without restrictions.

```bash
git fetch origin
git rebase origin/develop
```

If conflicts occur:
```bash
git add .
git rebase --continue
```

---

## Pushing After Rebase
```bash
git push --force-with-lease
```

✔ Safe  
❌ Never use `--force`

---

## Synchronizing Local with Remote (Exact Match)
If local and remote diverge and local changes must be discarded:

```bash
git fetch origin
git reset --hard origin/feature/my-feature
```

⚠️ This permanently deletes local-only commits.

---

## Pull Configuration (Mandatory)
To prevent accidental merges:

```bash
git config --global pull.ff only
```

This enforces fast-forward only pulls.

---

## IDE and Local Files
IDE configuration files must **never** be committed.

Add to `.gitignore`:
```gitignore
.idea/
.vscode/
*.iml
```

---

## Pull Requests
- Base branch: `develop`
- Keep PRs small and focused
- Prefer **rebase or squash** merge strategies
- Delete feature branch after merge

---

## Forbidden Actions
❌ Direct commits to `main` or `develop`  
❌ Committing IDE files  
❌ `git pull` without `--ff-only`  
❌ `git push --force`  
❌ Long-lived feature branches  

---

## Mental Rule
> If local ≠ remote, **stop and synchronize consciously**.

---

## Summary
- Feature branches + rebase
- Protected main branches
- Fast-forward only pulls
- Remote is the source of truth
- Clean history at all times
